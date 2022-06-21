package br.com.acelera.biblioteca.converts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.acelera.biblioteca.dto.inputs.AutorInput;
import br.com.acelera.biblioteca.entities.AutorEntity;

@Component
public class AutorConvert {

	@Autowired
	private ModelMapper modelMapper;

	public AutorEntity inputToEntity(AutorInput autorInput) {
		AutorEntity autor = modelMapper.map(autorInput, AutorEntity.class);
		return autor;
	}
	
	
}
