package com.project.Helpin.controller;



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

import com.project.Helpin.model.Endereco;
import com.project.Helpin.repository.EnderecoRepository;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco adicionar(@RequestBody Endereco endereço) {
		return enderecoRepository.save(endereço);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Endereco> remover(@PathVariable Long id){
		
		Optional<Endereco> opcional = enderecoRepository.findById(id);
		if (opcional.isPresent()) {
			enderecoRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping
	public List<Endereco> listar(){
		
		
	return  enderecoRepository.findAll();
	}
	
	




}
