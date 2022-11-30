package br.com.helpin.api.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id_usuario;
	private String nome;
	private String celular;
	private String CPF;
	private String email;
	private String senha;

	@OneToMany
	@JoinColumn(name = "id_usuario")
	private List<Endereco> Endereco;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	

	@OneToMany
	@JoinColumn(name = "id_usuario")
	private List<Veiculo> Veiculousuario;


	@OneToMany
	@JoinColumn(name = "id_usuario")
	private List<Atendimento> Atendimento;


	@ManyToMany
	@JoinTable(name = "usuario_parceiro", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_parceiro"))
	private List<Parceiro> parceiro;

	
	public List<Veiculo> getVeiculousuario() {
		return Veiculousuario;
	}
	public List<Atendimento> getAtendimento() {
		return Atendimento;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = new BCryptPasswordEncoder().encode(senha);
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Endereco> getEndereco() {
		return Endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		Endereco = endereco;
	}

	public List<Parceiro> getParceiro() {
		return parceiro;
	}

	public void setParceiro(List<Parceiro> parceiro) {
		this.parceiro = parceiro;
	}

	public void setVeiculousuario(List<Veiculo> veiculousuario) {
		Veiculousuario = veiculousuario;
	}

	public void setAtendimento(List<Atendimento> atendimento) {
		Atendimento = atendimento;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return this.perfis;
	}
	
	@Override
	public String getPassword() {

		return this.senha;
	}
	
	@Override
	public String getUsername() {

		return this.email;
	}
	
	@Override
	public boolean isAccountNonExpired() {

		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {

		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}
	
	@Override
	public boolean isEnabled() {

		return true;
	}
	
	

}
