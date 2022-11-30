package br.com.helpin.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helpin.api.model.Parceiro;

public interface ParceiroRepository extends JpaRepository<Parceiro , Long> {

}
