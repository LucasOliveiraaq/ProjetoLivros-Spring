package com.lucas.livros.service;

import java.util.List;

import com.lucas.livros.dto.request.LivroRequestDTO;
import com.lucas.livros.dto.response.LivroResponseDTO;

public interface LivroService {
	LivroResponseDTO findById(int id);
	
	List<LivroResponseDTO> findAll();
	
	LivroResponseDTO register(LivroRequestDTO registerLivroDto);
	
	LivroResponseDTO update(Integer id, LivroRequestDTO registerLivroDto);
	
	String delete(Integer id);
}
