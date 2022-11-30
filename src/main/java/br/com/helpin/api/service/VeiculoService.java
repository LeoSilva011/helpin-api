package br.com.helpin.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.helpin.api.model.Usuario;
import br.com.helpin.api.model.Veiculo;
import br.com.helpin.api.repository.VeiculoRepository;
import br.com.helpin.exception.EntidadeEmUsoException;
import br.com.helpin.exception.EntidadeNaoEncontradaException;

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
			throw new EntidadeEmUsoException(String.format("Veiculo com numero de placa %s já foi cadastrado", veiculo.getPlaca()));
		}
		return veiculoRepository.save(veiculo);
			
	}
	
	public void removerVeiculo(@PathVariable Long id){
		
		try {

			veiculoRepository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de id com id %d", id));
		}
	}
	
	
	public List<Veiculo> listarVeiculos(){
		return veiculoRepository.findAll();
	}
		
	
	

}
