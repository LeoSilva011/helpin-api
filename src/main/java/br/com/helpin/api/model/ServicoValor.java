package br.com.helpin.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ServicoValor {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long idservico_valor;
	private String valor;
	private String app_gratis;
	private Long id_parceiro;
	private Long id_servico;

	@OneToMany
	@JoinColumn(name = "idservico_valor")
	private List<AtendimentoServico> atendimentoservico;

	public List<AtendimentoServico> getAtendimentoservico() {
		return atendimentoservico;
	}

	public Long getIdservico_valor() {
		return idservico_valor;
	}

	public void setIdservico_valor(Long idservico_valor) {
		this.idservico_valor = idservico_valor;
	}

	public Long getId_servico() {
		return id_servico;
	}

	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}

	public void setAtendimentoservico(List<AtendimentoServico> atendimentoservico) {
		this.atendimentoservico = atendimentoservico;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getApp_gratis() {
		return app_gratis;
	}

	public void setApp_gratis(String app_gratis) {
		this.app_gratis = app_gratis;
	}

	public Long getId_parceiro() {
		return id_parceiro;
	}

	public void setId_parceiro(Long id_parceiro) {
		this.id_parceiro = id_parceiro;
	}

	public void setAtendimentoserviço(List<AtendimentoServico> atendimentoservico) {
		this.atendimentoservico = atendimentoservico;
	}

}
