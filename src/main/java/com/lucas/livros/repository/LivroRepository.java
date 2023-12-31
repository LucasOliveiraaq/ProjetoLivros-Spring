package com.lucas.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.livros.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{
}
