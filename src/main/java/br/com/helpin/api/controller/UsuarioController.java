package br.com.helpin.api.controller;



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

import br.com.helpin.api.model.Usuario;
import br.com.helpin.api.service.UsuarioService;
import br.com.helpin.exception.EntidadeEmUsoException;
import br.com.helpin.exception.EntidadeNaoEncontradaException;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;


	@PostMapping("/cadastro")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> adicionar(@RequestBody Usuario usuario) {
		try {
			usuario = usuarioService.salvarNovoUsuario(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
	try {
			
		usuarioService.apagarUsuario(id);
	    return ResponseEntity.noContent().build();
			
		
		}catch (EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	@GetMapping("/listar")
	public List<Usuario> listar(){

		return  usuarioService.ListarUsuarios();
	}
	

}
