package com.generation.blogreceitas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogreceitas.model.Receita;
import com.generation.blogreceitas.repository.ReceitaRepository;

import jakarta.validation.Valid;

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

	@GetMapping("/titulo/{tituloReceita}")
	public ResponseEntity<List<Receita>> findByTituloReceita(@PathVariable String tituloReceita) {
		return ResponseEntity.ok(receitaRepository.findAllByTituloReceitaContainingIgnoreCase(tituloReceita));
	}

	@PostMapping
	public ResponseEntity<Receita> criarNovaReceita(@Valid @RequestBody Receita receita) {
		return ResponseEntity.status(HttpStatus.CREATED).body(receitaRepository.save(receita));
	}

	@PutMapping
	public ResponseEntity<Receita> atualizarReceita(@Valid @RequestBody Receita receita) {
		return receitaRepository.findById(receita.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(receitaRepository.save(receita)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletarReceita(@PathVariable Long id) {
		Optional<Receita> receita = receitaRepository.findById(id);
		
		if(receita.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		receitaRepository.deleteById(id);
	}
}
