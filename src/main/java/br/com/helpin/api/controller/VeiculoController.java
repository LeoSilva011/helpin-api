package br.com.helpin.api.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpin.api.model.Veiculo;
import br.com.helpin.api.service.VeiculoService;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	

	@Autowired
	private VeiculoService veiculoService;
	

	
	@GetMapping("/listar")
	public List<Veiculo> listar(){
		
		
		return  veiculoService.listarVeiculos();
	}
	




}
