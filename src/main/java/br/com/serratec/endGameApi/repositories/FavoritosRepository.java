package br.com.serratec.endGameApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.endGameApi.models.Favoritos;

public interface FavoritosRepository extends JpaRepository<Favoritos, Integer>{

}
