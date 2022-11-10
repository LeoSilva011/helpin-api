package com.project.Helpin.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Atendimento {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id_atendimento;
	private String veiculo;
	private String encontro;
	private Long id_usuario;

	@OneToMany
	@JoinColumn(name = "id_atendimento")
	private List<AtendimentoServico> atendimentoserviço;

	public List<AtendimentoServico> getAtendimentoserviço() {
		return atendimentoserviço;
	}

	public Long getId_atendimento() {
		return id_atendimento;
	}

	public void setId_atendimento(Long id_atendimento) {
		this.id_atendimento = id_atendimento;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getEncontro() {
		return encontro;
	}

	public void setEncontro(String encontro) {
		this.encontro = encontro;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setAtendimentoserviço(List<AtendimentoServico> atendimentoserviço) {
		this.atendimentoserviço = atendimentoserviço;
	}

	
}
