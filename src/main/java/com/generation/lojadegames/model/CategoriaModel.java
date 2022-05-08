package com.generation.lojadegames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_categoria")
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;

	@NotNull
	public String tema;
	
	@NotNull
	public Long faixaetaria;
	
	@OneToMany(mappedBy = "categoria", cascade= CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<ProdutoModel>produto;

	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Long getFaixaetaria() {
		return faixaetaria;
	}

	public void setFaixaetaria(Long faixaetaria) {
		this.faixaetaria = faixaetaria;
	}
	
	
}
