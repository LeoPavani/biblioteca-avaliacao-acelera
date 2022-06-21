package br.com.acelera.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acelera.biblioteca.dto.inputs.EditaAutorInput;
import br.com.acelera.biblioteca.entities.AutorEntity;
import br.com.acelera.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;

	public AutorEntity insere(AutorEntity autor) {
		AutorEntity autorCriado = autorRepository.save(autor);
		return autorCriado;
	}

	public List<AutorEntity> listaTodos() {
		List<AutorEntity> autores = autorRepository.findAll();
		return autores;
	}

	public AutorEntity buscaPorId(Long id) {
		AutorEntity autor = autorRepository.findById(id).orElseThrow();
		return autor;
	}

	public AutorEntity altera(AutorEntity autor, EditaAutorInput input) {
		if(!input.getNome().isEmpty()) {
			autor.setNome(input.getNome());
		}
		if(!input.getBiografia().isEmpty()) {
			autor.setBiografia(input.getBiografia());
		}
		return autor;
	}

	
}
