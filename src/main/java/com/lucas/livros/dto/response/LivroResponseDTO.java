package com.lucas.livros.dto.response;

import com.lucas.livros.models.Livro;

import lombok.Getter;

@Getter
public class LivroResponseDTO {

	private int id;
	private String titulo;
	private String autor;
	private Integer numPaginas;
	private Integer statusLeitura;
	private String imagemLivro;
	private String emprestimo;
	
	public LivroResponseDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor();
		this.numPaginas = livro.getNumPaginas();
		this.statusLeitura = livro.getStatusLeitura();
		this.imagemLivro = livro.getImagemLivro();
		this.emprestimo = livro.getEmprestimo();
	}
}
