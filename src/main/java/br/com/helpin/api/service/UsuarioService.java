package br.com.helpin.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.helpin.api.model.Usuario;
import br.com.helpin.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario salvarNovoUsuario(Usuario usuario) {
		Boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail())
				.stream()
				.anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));
		if(emailEmUso) {
			throw new RuntimeException("Já existe um usuario cadastrado com esse E-mail");
		}
		return usuarioRepository.save(usuario);
		
		
	}
	
	
	public List<Usuario> ListarUsuarios() {
	
		return usuarioRepository.findAll();
		
		
	}
	
	
	public ResponseEntity<Usuario> apagarUsuario(Long idUsuario) {
		Optional<Usuario> opcional = usuarioRepository.findById(idUsuario);
		if (opcional.isPresent()) {
			usuarioRepository.deleteById(idUsuario);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	
	
}
