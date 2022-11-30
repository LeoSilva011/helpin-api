package br.com.helpin.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helpin.api.model.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento , Long> {

}
