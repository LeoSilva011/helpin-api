package com.project.Helpin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Helpin.model.Usuario;
import com.project.Helpin.repository.UsuarioRepository;

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
