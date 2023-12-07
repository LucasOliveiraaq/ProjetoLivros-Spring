package com.lucas.livros.service;

import java.util.List;

import com.lucas.livros.dto.request.LivroRequestDto;
import com.lucas.livros.dto.response.LivroResponseDTO;

public interface LivroService {
	LivroResponseDTO findById(int id);
	
	List<LivroResponseDTO> findAll();
	
	LivroResponseDTO register(LivroRequestDto registerLivroDto);
	
	LivroResponseDTO update(LivroRequestDto registerLivroDto, int id);
	
	String delete(int id);
}
