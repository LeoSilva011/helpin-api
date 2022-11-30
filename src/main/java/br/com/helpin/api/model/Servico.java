package br.com.helpin.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Servico {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id_servico;
	private String nome;
	private Long idservico_valor;

	@OneToMany
	@JoinColumn(name = "id_serviço")
	private List<ServicoValor> servico_valor;

	public List<ServicoValor> getServico_valor() {
		return servico_valor;
	}


	public Long getId_servico() {
		return id_servico;
	}


	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public Long getIdservico_valor() {
		return idservico_valor;
	}


	public void setIdservico_valor(Long idservico_valor) {
		this.idservico_valor = idservico_valor;
	}


	public void setServiço_valor(List<ServicoValor> servico_valor) {
		this.servico_valor = servico_valor;
	}

	
}
