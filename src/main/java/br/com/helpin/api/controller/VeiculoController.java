package br.com.helpin.api.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpin.api.model.Usuario;
import br.com.helpin.api.model.Veiculo;
import br.com.helpin.api.service.VeiculoService;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	

	@Autowired
	private VeiculoService veiculoService;
	


	@PostMapping("/criar")
	public Veiculo adicionar(@RequestBody Veiculo veiculousuario, @AuthenticationPrincipal Usuario usuario) {
		
		return veiculoService.salvarVeiculo(veiculousuario, usuario);
	}
	
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Veiculo> remover(@PathVariable Long id){
		
		return veiculoService.removerVeiculo(id);
	}
	
	
	@GetMapping("/listar")
	public List<Veiculo> listar(){
		
		
		return  veiculoService.listarVeiculos();
	}
	




}
