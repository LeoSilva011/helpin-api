package br.com.helpin.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity

public class Veiculo {
	
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long idveiculousuario;
	private String placa;
	private String modelo;
	private String ano;
	private String cor;
	private Long id_usuario;
	
	


	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Long getIdveiculousuario() {
		return idveiculousuario;
	}
	public void setIdveiculousuario(Long idveiculousuario) {
		this.idveiculousuario = idveiculousuario;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
