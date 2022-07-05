package br.com.serratec.endGameApi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.endGameApi.dtos.UsuarioDTO;
import br.com.serratec.endGameApi.exceptions.SenhaInvalidaException;
import br.com.serratec.endGameApi.exceptions.UsuarioExistenteException;
import br.com.serratec.endGameApi.exceptions.UsuarioInexistenteException;
import br.com.serratec.endGameApi.models.Usuario;
import br.com.serratec.endGameApi.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario retornaUsuario(String username) throws UsuarioInexistenteException {
		Optional<Usuario> optional = usuarioRepository.findByUsername(username);
		
		if (optional.isEmpty()) {
			throw new UsuarioInexistenteException();
		}
		
		return optional.get();
	}
	
	public void Inserir(Usuario usuario) throws UsuarioExistenteException {
		Optional<Usuario> optional = usuarioRepository.findByUsername(usuario.getUsername());
		if (optional.isPresent()) {
			throw new UsuarioExistenteException();
		}
		
		usuarioRepository.save(usuario);
	}
	
	public String login(UsuarioDTO loginInfo) throws UsuarioInexistenteException, SenhaInvalidaException {
		Optional<Usuario> optional = usuarioRepository.findByUsername(loginInfo.getUsername());
		
		if(optional.isEmpty()) {
			throw new UsuarioInexistenteException();
		}
		
		if(!optional.get().getSenha().equals(loginInfo.getSenha())) {
			throw new SenhaInvalidaException();
		}
		
		return optional.get().getHash();
	}
	
	public String getSpoonUsername(String username) throws UsuarioInexistenteException {
		Optional<Usuario> optional = usuarioRepository.findByUsername(username);
		
		if(optional.isEmpty()) {
			throw new UsuarioInexistenteException();
		}
		
		return optional.get().getSpoonUsername();
	}
}
