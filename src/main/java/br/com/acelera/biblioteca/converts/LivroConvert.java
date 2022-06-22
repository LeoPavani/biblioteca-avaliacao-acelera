package br.com.acelera.biblioteca.converts;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.acelera.biblioteca.dto.inputs.LivroInput;
import br.com.acelera.biblioteca.entities.AutorEntity;
import br.com.acelera.biblioteca.entities.LivroEntity;
import br.com.acelera.biblioteca.services.AutorService;

@Component
public class LivroConvert {
	
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private ModelMapper modelMapper;

	public LivroEntity inputToEntity(LivroInput livroInput) {
		LivroEntity livro = modelMapper.map(livroInput, LivroEntity.class);
		List<AutorEntity> listaDeAutores = new ArrayList<AutorEntity>();
		for(Long id : livroInput.getAutores()) {
			AutorEntity autor = autorService.buscaPorId(id);
			listaDeAutores.add(autor);
		}
		livro.setAutores(listaDeAutores);
		return livro;
	}

	
}
