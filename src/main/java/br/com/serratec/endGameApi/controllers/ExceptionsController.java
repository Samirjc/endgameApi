package br.com.serratec.endGameApi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.serratec.endGameApi.exceptions.SenhaInvalidaException;
import br.com.serratec.endGameApi.exceptions.UsuarioExistenteException;
import br.com.serratec.endGameApi.exceptions.UsuarioInexistenteException;

@RestControllerAdvice
public class ExceptionsController {
	@ExceptionHandler(UsuarioExistenteException.class)
	public ResponseEntity<String> handleUsuarioExistente() {
		String msg = "Usuário já existe";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(UsuarioInexistenteException.class)
	public ResponseEntity<String> handleUsuarioInexistente() {
		String msg = "Usuário não existe";
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(SenhaInvalidaException.class)
	public ResponseEntity<String> handleSenhaInvalidaInexistente() {
		String msg = "Senha inválida";
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).header("errorMsg", msg).build();
	}
}
