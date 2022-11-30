package br.com.helpin.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;




@Entity
public class Parceiro {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id_parceiro;
	private String nome;
	
	
	
	
	@OneToMany
	@JoinColumn(name = "id_parceiro")
	private List<ServicoValor> servico_valor;

	public List<ServicoValor> getServico_valor() {
		return servico_valor;
	}	
	

	public Long getId_parceiro() {
		return id_parceiro;
	}

	public void setId_parceiro(Long id_parceiro) {
		this.id_parceiro = id_parceiro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}




	public void setServiço_valor(List<ServicoValor> servico_valor) {
		this.servico_valor = servico_valor;
	}

		
		
		
		

		
	
	
}
