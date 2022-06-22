package br.com.acelera.biblioteca.restControllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acelera.biblioteca.converts.AutorConvert;
import br.com.acelera.biblioteca.dto.inputs.AutorInput;
import br.com.acelera.biblioteca.dto.inputs.EditaAutorInput;
import br.com.acelera.biblioteca.entities.AutorEntity;
import br.com.acelera.biblioteca.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorConvert autorConvert;
	
	@Autowired
	private AutorService autorService;

	
	@PostMapping
	public AutorEntity insereAutor(@RequestBody @Valid AutorInput autorInput) {
		AutorEntity autor = autorConvert.inputToEntity(autorInput);
		AutorEntity autorCriado = autorService.insere(autor);
		return autorCriado;
	}
	
	@GetMapping
	public List<AutorEntity> listaAutores() {
		List<AutorEntity> listaDeAutores = autorService.listaTodos();
		return listaDeAutores;
	}
	
	@GetMapping("{id}")
	public AutorEntity buscaAutorPorId(@PathVariable Long id) {
		AutorEntity autor = autorService.buscaPorId(id);
		return autor;
	}
	
	@PutMapping("{id}")
	public AutorEntity alteraAutor(@PathVariable Long id, @RequestBody @Valid EditaAutorInput input) {
		AutorEntity autor = autorService.buscaPorId(id);
		AutorEntity autorAlterado = autorService.altera(autor, input);
		return autorAlterado;
	}
	
}
