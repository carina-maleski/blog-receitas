package com.generation.blogreceitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.blogreceitas.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

	public List<Receita> findAllByTituloReceitaContainingIgnoreCase(@Param("tituloReceita") String tituloReceita);

}
