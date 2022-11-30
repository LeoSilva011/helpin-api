package br.com.helpin.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpin.api.model.ServicoValor;
import br.com.helpin.api.repository.ServicoValorRepository;

@RestController
@RequestMapping("/servicoValor")
public class ServicoValorController {

	@Autowired
	private ServicoValorRepository servicovalorRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoValor adicionar(@RequestBody ServicoValor serviço_valor) {
		return servicovalorRepository.save(serviço_valor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ServicoValor> remover(@PathVariable Long id) {

		Optional<ServicoValor> opcional = servicovalorRepository.findById(id);
		if (opcional.isPresent()) {
			servicovalorRepository.deleteById(id);

			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping

	public List<ServicoValor> listar() {

		return servicovalorRepository.findAll();
	}

}
