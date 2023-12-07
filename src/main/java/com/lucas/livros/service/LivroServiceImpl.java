package com.lucas.livros.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.lucas.livros.dto.request.LivroRequestDto;
import com.lucas.livros.dto.response.LivroResponseDTO;
import com.lucas.livros.models.Livro;
import com.lucas.livros.repository.LivroRepository;
import com.lucas.livros.util.LivroMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary //vai dizer que vai ser a implementação a ser carregada.
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService{

	private final LivroRepository livroRepository;
	
	private final LivroMapper livroMapper;
	
	@Override
	public LivroResponseDTO findById(int id) {
		Livro livro = returnLivro(id);
		return livroMapper.toLivroDTO(livro);
	}

	@Override
	public List<LivroResponseDTO> findAll() {
		return null;
	}

	@Override
	public LivroResponseDTO register(LivroRequestDto registerLivroDto) {
		return null;
	}

	@Override
	public LivroResponseDTO update(LivroRequestDto registerLivroDto, int id) {
		return null;
	}

	@Override
	public String delete(int id) {
		return null;
	}
	
	private Livro returnLivro(int id) {
		return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Id do livro não existe"));
	}

}
