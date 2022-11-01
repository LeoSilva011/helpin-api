package com.project.Helpin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Helpin.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo , Long> {
	Optional<Veiculo> findByPlaca(String placa);
}
