package com.lucas.livros.dto.request;

import lombok.Getter;

@Getter
public class LivroRequestDTO {

	private String titulo;
	private String autor;
	private Integer numPaginas;
	private Integer statusLeitura;
	private String imagemLivro;
	private String emprestimo;
}
