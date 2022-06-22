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
import br.com.acelera.biblioteca.dto.outputs.AutorOutput;
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
	public AutorOutput insereAutor(@RequestBody @Valid AutorInput autorInput) {
		AutorEntity autor = autorConvert.inputToEntity(autorInput);
		AutorEntity autorCriado = autorService.insere(autor);
		AutorOutput autorOutput = autorConvert.entityToOutput(autorCriado);
		return autorOutput;
	}
	
	@GetMapping
	public List<AutorOutput> listaAutores() {
		List<AutorEntity> listaDeAutores = autorService.listaTodos();
		List<AutorOutput> listaDeAutoresOutput = autorConvert.entityListToOutputList(listaDeAutores);
		return listaDeAutoresOutput;
	}
	
	@GetMapping("{id}")
	public AutorOutput buscaAutorPorId(@PathVariable Long id) {
		AutorEntity autor = autorService.buscaPorId(id);
		AutorOutput autorOutput = autorConvert.entityToOutput(autor);
		return autorOutput;
	}
	
	@PutMapping("{id}")
	public AutorOutput alteraAutor(@PathVariable Long id, @RequestBody @Valid EditaAutorInput input) {
		AutorEntity autor = autorService.buscaPorId(id);
		AutorEntity autorAlterado = autorService.altera(autor, input);
		AutorOutput autorOutput = autorConvert.entityToOutput(autorAlterado);
		return autorOutput;
	}
	
}
