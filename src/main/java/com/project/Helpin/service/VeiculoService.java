package com.project.Helpin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.Helpin.model.Usuario;
import com.project.Helpin.model.Veiculo;
import com.project.Helpin.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	
	public Veiculo salvarVeiculo(Veiculo veiculo, Usuario usuario) {
		veiculo.setId_usuario(usuario.getId_usuario());
		Boolean veiculoEmUso = veiculoRepository.findByPlaca(veiculo.getPlaca())
				.stream()
				.anyMatch(usuarioExistente -> !usuarioExistente.equals(veiculo));
		if(veiculoEmUso) {
			throw new RuntimeException("Veiculo já cadastrado");
		}
		return veiculoRepository.save(veiculo);
			
	}
	
	public ResponseEntity<Veiculo> removerVeiculo(@PathVariable Long id){
		
		Optional<Veiculo> opcional = veiculoRepository.findById(id);
		if (opcional.isPresent()) {
			veiculoRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	public List<Veiculo> listarVeiculos(){
		return veiculoRepository.findAll();
	}
		
	
	

}
