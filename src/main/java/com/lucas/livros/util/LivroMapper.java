package com.lucas.livros.util;

import com.lucas.livros.dto.request.LivroRequestDto;
import com.lucas.livros.dto.response.LivroResponseDTO;
import com.lucas.livros.models.Livro;

public class LivroMapper {

	public Livro toLivro(LivroRequestDto livroDto) {
		return Livro.builder()
					.titulo(livroDto.getTitulo())
					.autor(livroDto.getAutor())
					.numPaginas(livroDto.getNumPaginas())
					.statusLeitura(livroDto.getStatusLeitura())
					.imagemLivro(livroDto.getImagemLivro())
					.emprestimo(livroDto.getEmprestimo())
					.build();
	}
	
	public LivroResponseDTO toLivroDTO(Livro livro) {
		return new LivroResponseDTO(livro);
	}
}
