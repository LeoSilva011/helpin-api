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

import br.com.helpin.api.model.AtendimentoServico;
import br.com.helpin.api.repository.AtendimentoServicoRepository;


@RestController
@RequestMapping("/AtendimentoServico")
public class AtendimentoServicoController {
	
	@Autowired
	private AtendimentoServicoRepository atendimentoServicoRepository;
	


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AtendimentoServico adicionar(@RequestBody AtendimentoServico atendimentoservi├žo) {
		return atendimentoServicoRepository.save(atendimentoservi├žo);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<AtendimentoServico> remover(@PathVariable Long id){
		
		Optional<AtendimentoServico> opcional = atendimentoServicoRepository.findById(id);
		if (opcional.isPresent()) {
			atendimentoServicoRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
@GetMapping
	
	public List<AtendimentoServico> listar(){
		
		
		return  atendimentoServicoRepository.findAll();
	}
	
	
	



}
