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

import br.com.helpin.api.model.Atendimento;
import br.com.helpin.api.repository.AtendimentoRepository;


@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Atendimento adicionar(@RequestBody Atendimento atendimento) {
		return atendimentoRepository.save(atendimento);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Atendimento> remover(@PathVariable Long id){
		
		Optional<Atendimento> opcional = atendimentoRepository.findById(id);
		if (opcional.isPresent()) {
			atendimentoRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
@GetMapping
	
	public List<Atendimento> listar(){
		
		
		return  atendimentoRepository.findAll();
	}
	



}
