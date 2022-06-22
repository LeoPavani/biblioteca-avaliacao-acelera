package br.com.acelera.biblioteca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acelera.biblioteca.entities.LivroEntity;
import br.com.acelera.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	public LivroEntity insere(LivroEntity livro) {
		LivroEntity livroCriado = livroRepository.save(livro);
		return livroCriado;
	}

}
