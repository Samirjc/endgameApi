package br.com.serratec.endGameApi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Favoritos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@ManyToOne
	private Usuario usuario;
	
	@NotNull
	private Integer receitaId;
	

	public Favoritos() {
		super();
	}

	public Favoritos(Integer id, @NotNull Usuario usuario, @NotNull Integer receitaId) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.receitaId = receitaId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getReceitaId() {
		return receitaId;
	}

	public void setReceitaId(Integer receitaId) {
		this.receitaId = receitaId;
	}
}
