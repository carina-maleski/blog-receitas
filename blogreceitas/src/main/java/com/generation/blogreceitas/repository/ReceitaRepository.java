package com.generation.blogreceitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.blogreceitas.model.Categoria;
import com.generation.blogreceitas.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

	public List<Receita> findAllByCategoria(@Param("categoria") Categoria categoria);

	public List<Receita> findAllByTituloReceitaContaingIgnoreCase(@Param("tituloReceita") String tituloReceita);

}
