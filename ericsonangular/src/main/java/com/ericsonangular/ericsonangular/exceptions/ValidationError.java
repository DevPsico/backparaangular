package com.ericsonangular.ericsonangular.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardErro{
	
	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationError(LocalDateTime timestamp, Integer status, String message, String path) {
		super(timestamp, status, message, path);
		// TODO Auto-generated constructor stub
	}
	
	public List<FieldMessage> getErros(){
		
		return erros;
	}

	public void addErros(String fieldName, String message) {
		
		this.erros.add(new FieldMessage(fieldName, message));
		
	}
}