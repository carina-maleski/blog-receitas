package com.generation.blogreceitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogreceitas.model.Categoria;
import com.generation.blogreceitas.model.Receita;
import com.generation.blogreceitas.repository.ReceitaRepository;

@RestController
@RequestMapping("/receitas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReceitaController {

	@Autowired
	private ReceitaRepository receitaRepository;

	@GetMapping
	public ResponseEntity<List<Receita>> findAll() {
		return ResponseEntity.ok(receitaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Receita> findById(@PathVariable Long id) {
		return receitaRepository.findById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Receita>> findByCategoria(@PathVariable Categoria categoria) {
		return ResponseEntity.ok(receitaRepository.findAllByCategoria(categoria));
	}

	@GetMapping("/titulo/{tituloReceita}")
	public ResponseEntity<List<Receita>> findByTituloReceita(@PathVariable String tituloReceita) {
		return ResponseEntity.ok(receitaRepository.findAllByTituloReceitaContaingIgnoreCase(tituloReceita));
	}

}
