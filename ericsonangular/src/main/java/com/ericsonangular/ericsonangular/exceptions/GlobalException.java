package com.ericsonangular.ericsonangular.exceptions;

import java.time.LocalDateTime;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardErro> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request){
		
		StandardErro se = new StandardErro(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<StandardErro> handleGenericException(Exception ex, HttpServletRequest request) {
        StandardErro standardErro = new StandardErro(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro interno no servidor: " + ex.getMessage(),
                request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(standardErro);
    }
	
}