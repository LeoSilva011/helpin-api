package com.project.Helpin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;




@Entity
public class AtendimentoServico {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long idatendimentoservico;
	private String valor;
	private String app_gratis;
	private Long id_atendimento;
	private Long idservico_valor;
	
	
	public Long getIdatendimentoservico() {
		return idatendimentoservico;
	}
	public void setIdatendimentoservico(Long idatendimentoservico) {
		this.idatendimentoservico = idatendimentoservico;
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
	public Long getId_atendimento() {
		return id_atendimento;
	}
	public void setId_atendimento(Long id_atendimento) {
		this.id_atendimento = id_atendimento;
	}
	public Long getIdservico_valor() {
		return idservico_valor;
	}
	public void setIdservico_valor(Long idservico_valor) {
		this.idservico_valor = idservico_valor;
	}
	
	
	
	
	
	
	
	

	
	

	
	
	
	
	
}
