package com.lucas.livros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lucas.livros.dto.DefaultError;

@ControllerAdvice
public class LivroExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity InternalErroException(RuntimeException i) {
		DefaultError error = new DefaultError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro");
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity exceptionErro(Exception e) {
		DefaultError error = new DefaultError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro desconhecido");
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
