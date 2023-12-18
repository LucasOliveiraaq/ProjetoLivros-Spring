package com.lucas.livros.util;

import java.util.List;
import java.util.stream.Collectors;

import com.lucas.livros.dto.request.LivroRequestDTO;
import com.lucas.livros.dto.response.LivroResponseDTO;
import com.lucas.livros.models.Livro;

public class LivroMapper {

	public Livro toLivro(LivroRequestDTO livroDto) {
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
	
	public List<LivroResponseDTO> toLivroDTO(List<Livro> list){
		return list.stream().map(LivroResponseDTO::new).collect(Collectors.toList());
	}
	
	public void updateLivroData(Livro livro, LivroRequestDTO livroRequestDTO) {
		livro.setTitulo(livroRequestDTO.getTitulo());
		livro.setAutor(livroRequestDTO.getAutor());
		livro.setNumPaginas(livroRequestDTO.getNumPaginas());
		livro.setStatusLeitura(livroRequestDTO.getStatusLeitura());
		livro.setImagemLivro(livroRequestDTO.getImagemLivro());
		livro.setEmprestimo(livroRequestDTO.getEmprestimo());
	}
}
