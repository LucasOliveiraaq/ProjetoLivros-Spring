package com.lucas.livros.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	@Setter(AccessLevel.NONE)
	private int id;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String autor;
	private Integer numPaginas;
	@Column(nullable = false)
	private Integer statusLeitura;
	private String imagemLivro;
	private String emprestimo;
	
	@Builder
	public Livro(String titulo, String autor, Integer numPaginas, Integer statusLeitura, String imagemLivro,
			String emprestimo) {
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
		this.statusLeitura = statusLeitura;
		this.imagemLivro = imagemLivro;
		this.emprestimo = emprestimo;
	}
	
}
