package com.project.Helpin.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.project.Helpin.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class TokenService {
	
	@Value("${helpin.jwt.expiration}")
	private String expiration;
	
	@Value("${helpin.jwt.secret}")
	private String secret;
	
	
	
	
	
	public String gerarToken(Authentication authentication) {
	
		System.out.println("Aqui");
			
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		System.out.println("Aqui2");
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

		
		System.out.println("Aqui3");

		
		return Jwts.builder()
				.setIssuer("API do projeto Guarani")
				.setSubject(logado.getId_usuario().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();


	}


	
	//valida se o token é valido
	public boolean isTokenValido(String token) {
		
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		
		}
	}


	//pega o id do usuario correspondente ao token
	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}
	

	

}