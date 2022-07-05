package br.com.serratec.endGameApi.dtos;

public class UsuarioDTO {
	private String username;
	private String senha;
	
	
	public UsuarioDTO() {
		super();
	}
	public UsuarioDTO(String username, String senha) {
		super();
		this.username = username;
		this.senha = senha;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
