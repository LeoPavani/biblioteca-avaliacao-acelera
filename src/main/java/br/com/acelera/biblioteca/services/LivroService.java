package br.com.acelera.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acelera.biblioteca.dto.inputs.EditaLivroInput;
import br.com.acelera.biblioteca.entities.AutorEntity;
import br.com.acelera.biblioteca.entities.LivroEntity;
import br.com.acelera.biblioteca.repositories.AutorRepository;
import br.com.acelera.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;

	public LivroEntity insere(LivroEntity livro) {
		LivroEntity livroCriado = livroRepository.save(livro);
		return livroCriado;
	}

	public List<LivroEntity> listaTodos() {
		List<LivroEntity> livros = livroRepository.findAll();
		return livros;
	}

	public LivroEntity buscaPorId(Long id) {
		LivroEntity livro = livroRepository.findById(id).orElseThrow();
		return livro;
	}

	public void deleta(LivroEntity livro) {
		livroRepository.delete(livro);
		
	}

	public LivroEntity altera(LivroEntity livro, EditaLivroInput input) {
		if(!input.getTitulo().isBlank()) {
			livro.setTitulo(input.getTitulo());
		}
		if(!input.getAnoLancamento().isBlank()) {
			livro.setAnoLancamento(input.getAnoLancamento());
		}
		if(!input.getAutores().isEmpty()) {
			List<AutorEntity> listaDeAutores = new ArrayList<>();
			for(Long id : input.getAutores()) {
				AutorEntity autor = autorRepository.findById(id).orElseThrow();
				listaDeAutores.add(autor);
			}
			livro.setAutores(listaDeAutores);
		}
		livroRepository.save(livro);
		return livro;
	}

}
