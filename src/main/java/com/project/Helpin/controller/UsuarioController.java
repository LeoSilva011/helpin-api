package com.project.Helpin.controller;



import java.util.List;

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

import com.project.Helpin.model.Usuario;
import com.project.Helpin.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;


	@PostMapping("/cadastro")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return usuarioService.salvarNovoUsuario(usuario);
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<Usuario> remover(@PathVariable Long id){
		
		return usuarioService.apagarUsuario(id);
	}
	
	
	@GetMapping("/listar")
	public List<Usuario> listar(){

		return  usuarioService.ListarUsuarios();
	}
	

}
