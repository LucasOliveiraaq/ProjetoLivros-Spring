package com.lucas.livros.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lucas.livros.dto.request.LivroRequestDTO;
import com.lucas.livros.dto.response.LivroResponseDTO;
import com.lucas.livros.service.LivroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/Livro")
@RequiredArgsConstructor
public class LivroController {

	private final LivroService livroService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LivroResponseDTO> findById(@PathVariable(name = "id") Integer id) {
		return ResponseEntity.ok().body(livroService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<LivroResponseDTO>> findAll() {
		return ResponseEntity.ok().body(livroService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<LivroResponseDTO> register(@RequestBody LivroRequestDTO livroRequestDTO, UriComponentsBuilder builder) {
		LivroResponseDTO livroResponseDTO = livroService.register(livroRequestDTO);
		URI uri = builder.path("/livro/{id}").buildAndExpand(livroResponseDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(livroResponseDTO);	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroResponseDTO> update(@RequestBody LivroRequestDTO livroRequestDTO, @PathVariable(name = "id") Integer id) {
		return ResponseEntity.ok().body(livroService.update(id, livroRequestDTO));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id){
		return ResponseEntity.ok().body(livroService.delete(id));
	}
	
}
