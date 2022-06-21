package br.com.acelera.biblioteca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
}
