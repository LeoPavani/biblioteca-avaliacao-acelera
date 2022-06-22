package br.com.acelera.biblioteca.converts;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.acelera.biblioteca.dto.inputs.AutorInput;
import br.com.acelera.biblioteca.dto.outputs.AutorOutput;
import br.com.acelera.biblioteca.entities.AutorEntity;

@Component
public class AutorConvert {

	@Autowired
	private ModelMapper modelMapper;

	public AutorEntity inputToEntity(AutorInput autorInput) {
		AutorEntity autor = modelMapper.map(autorInput, AutorEntity.class);
		return autor;
	}

	public AutorOutput entityToOutput(AutorEntity autorCriado) {
		AutorOutput autorOutput = modelMapper.map(autorCriado, AutorOutput.class);
		return autorOutput;
	}

	public List<AutorOutput> entityListToOutputList(List<AutorEntity> listaDeAutores) {
		List<AutorOutput> listaDeAutoresOutput = new ArrayList<>();
		for(AutorEntity autor : listaDeAutores) {
			AutorOutput autorOutput = this.entityToOutput(autor);
			listaDeAutoresOutput.add(autorOutput);
		}
		return listaDeAutoresOutput;
	}
	
	
}
