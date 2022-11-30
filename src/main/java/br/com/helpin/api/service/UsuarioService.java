package br.com.helpin.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.helpin.api.model.Usuario;
import br.com.helpin.api.repository.UsuarioRepository;
import br.com.helpin.exception.EntidadeEmUsoException;
import br.com.helpin.exception.EntidadeNaoEncontradaException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario salvarNovoUsuario(Usuario usuario) {
		Boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail()).stream()
				.anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));
		if (emailEmUso) {
			throw new EntidadeEmUsoException("Já existe um usuario cadastrado com esse E-mail");
		}
		return usuarioRepository.save(usuario);

	}

	public List<Usuario> ListarUsuarios() {

		return usuarioRepository.findAll();

	}

	public void apagarUsuario(Long idUsuario) {
		try {

			 usuarioRepository.deleteById(idUsuario);

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de usuario com id %d", idUsuario));
		}

	}

}
