package br.com.uol.teste.cadastrojogadores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.uol.teste.cadastrojogadores.model.Jogador;
import br.com.uol.teste.cadastrojogadores.model.ListaOrigemEnum;

public interface JogadorRepository extends CrudRepository<Jogador, Long>{

	@Query("SELECT distinct a.codinome FROM Jogador a WHERE a.origem=:origem")
	List<String> findDistinctCodinomeByOrigem(@Param("origem") ListaOrigemEnum origem);
}
