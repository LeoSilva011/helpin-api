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

import br.com.helpin.api.model.Parceiro;
import br.com.helpin.api.repository.ParceiroRepository;


@RestController
@RequestMapping("/parceiro")
public class ParceiroController {
	
	@Autowired
	private ParceiroRepository ParceiroRepository;
	


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Parceiro adicionar(@RequestBody Parceiro Parceiro) {
		return ParceiroRepository.save(Parceiro);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Parceiro> remover(@PathVariable Long id){
		
		Optional<Parceiro> opcional = ParceiroRepository.findById(id);
		if (opcional.isPresent()) {
			ParceiroRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
@GetMapping
	
	public List<Parceiro> listar(){
		
		
	return  ParceiroRepository.findAll();
	}



}
