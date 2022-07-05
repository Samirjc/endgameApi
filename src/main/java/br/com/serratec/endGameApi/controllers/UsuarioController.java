package br.com.serratec.endGameApi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.endGameApi.dtos.UsuarioDTO;
import br.com.serratec.endGameApi.exceptions.SenhaInvalidaException;
import br.com.serratec.endGameApi.exceptions.UsuarioExistenteException;
import br.com.serratec.endGameApi.exceptions.UsuarioInexistenteException;
import br.com.serratec.endGameApi.models.Usuario;
import br.com.serratec.endGameApi.services.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	
	@PostMapping("/usuario")
	public void createUsuario(@Valid @RequestBody Usuario usuario) throws UsuarioExistenteException {
		usuarioService.Inserir(usuario);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUsuario(@RequestBody UsuarioDTO loginInfo) throws UsuarioInexistenteException, SenhaInvalidaException {
		String hash = usuarioService.login(loginInfo);
		String spoonUsername = usuarioService.getSpoonUsername(loginInfo.getUsername());
		
		return ResponseEntity.ok().header("Authentication", hash).header("username", spoonUsername).build();
	}
	
	@GetMapping("/usuario/{username}")
	public Usuario getUsuario(@PathVariable String username) throws UsuarioInexistenteException {
		return usuarioService.retornaUsuario(username);
	}
}
