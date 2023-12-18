package com.lucas.livros.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.lucas.livros.dto.request.LivroRequestDTO;
import com.lucas.livros.dto.response.LivroResponseDTO;
import com.lucas.livros.models.Livro;
import com.lucas.livros.repository.LivroRepository;
import com.lucas.livros.util.LivroMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary //vai dizer que vai ser a implementação a ser carregada.
@RequiredArgsConstructor //quando foi instanciado essa class os atributos abaixo que estiver com final vai passar automaticamente.
public class LivroServiceImpl implements LivroService{

	private final LivroRepository livroRepository;
	
	private final LivroMapper livroMapper;
	
	@Override
	public LivroResponseDTO findById(int id) {
		return livroMapper.toLivroDTO(returnLivro(id));
	}

	@Override
	public List<LivroResponseDTO> findAll() {
		return livroMapper.toLivroDTO(livroRepository.findAll());
	}

	@Override
	public LivroResponseDTO register(LivroRequestDTO registerLivroDto) {
		Livro livro = livroMapper.toLivro(registerLivroDto);
		return livroMapper.toLivroDTO(livroRepository.save(livro));
	}

	@Override
	public LivroResponseDTO update(LivroRequestDTO registerLivroDto, int id) {
		Livro livro = returnLivro(id);
		livroMapper.updateLivroData(livro, registerLivroDto);
		return livroMapper.toLivroDTO(livroRepository.save(livro));
	}

	@Override
	public String delete(int id) {
		livroRepository.deleteById(id);
		return "Delete livro com id:" + id;
	}
	
	private Livro returnLivro(int id) {
		return livroRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id do livro não existe"));
	}

}
