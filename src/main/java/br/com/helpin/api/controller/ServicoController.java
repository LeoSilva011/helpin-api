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

import br.com.helpin.api.model.Servico;
import br.com.helpin.api.repository.ServicoRepository;


@RestController
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	private ServicoRepository serviçoRepository;
	


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico adicionar(@RequestBody Servico serviço) {
		return serviçoRepository.save(serviço);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Servico> remover(@PathVariable Long id){
		
		Optional<Servico> opcional = serviçoRepository.findById(id);
		if (opcional.isPresent()) {
			serviçoRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
@GetMapping
	
	public List<Servico> listar(){
		
		
	return  serviçoRepository.findAll();
	}




}
