package com.generation.blogreceitas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_receitas")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 3, message = "Insira pelo menos 3 caracteres.")
	private String tituloReceita;
	
	@NotBlank
	@Size(min = 3, message = "Insira pelo menos 3 caracteres.")
	private String ingredientes;
	
	@NotBlank
	@Size(min = 3, message = "Insira pelo menos 3 caracteres.")
	private String modoPreparo;
	
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("receita")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTituloReceita() {
		return tituloReceita;
	}

	public void setTituloReceita(String tituloReceita) {
		this.tituloReceita = tituloReceita;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
