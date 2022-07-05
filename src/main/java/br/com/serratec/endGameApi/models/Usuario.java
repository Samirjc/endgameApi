package br.com.serratec.endGameApi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String spoonUsername;
	
	private String nome;
	
	private String sobrenome;
	
	@NotNull
	private String senha;
	
	@NotNull
	private String email;
	
	@NotNull
	private String hash;
	
	@OneToMany(mappedBy = "usuario")
	private List<Favoritos> favoritos;
	

	public Usuario() {
		super();
	}

	public Usuario(Integer id, @NotNull String username, @NotNull String spoonUsername, String nome, String sobrenome,
			@NotNull String senha, @NotNull String email, @NotNull String hash, List<Favoritos> favoritos) {
		super();
		this.id = id;
		this.username = username;
		this.spoonUsername = spoonUsername;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senha = senha;
		this.email = email;
		this.hash = hash;
		this.favoritos = favoritos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSpoonUsername() {
		return spoonUsername;
	}

	public void setSpoonUsername(String spoonUsername) {
		this.spoonUsername = spoonUsername;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Favoritos> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favoritos> favoritos) {
		this.favoritos = favoritos;
	}
}
