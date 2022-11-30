package br.com.helpin.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helpin.api.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco , Long> {

}
