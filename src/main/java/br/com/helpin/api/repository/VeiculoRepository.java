package br.com.helpin.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helpin.api.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo , Long> {
	Optional<Veiculo> findByPlaca(String placa);
}
