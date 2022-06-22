package br.com.acelera.biblioteca.restControllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	public ResponseEntity<AutorOutput> insereAutor(@RequestBody @Valid AutorInput autorInput, UriComponentsBuilder uriBuilder) {
		AutorEntity autor = autorConvert.inputToEntity(autorInput);
		AutorEntity autorCriado = autorService.insere(autor);
		AutorOutput autorOutput = autorConvert.entityToOutput(autorCriado);
		URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autorOutput.getId()).toUri();
		return ResponseEntity.created(uri).body(autorOutput);
	}
	
	@GetMapping
	public ResponseEntity<List<AutorOutput>> listaAutores() {
		List<AutorEntity> listaDeAutores = autorService.listaTodos();
		List<AutorOutput> listaDeAutoresOutput = autorConvert.entityListToOutputList(listaDeAutores);
		return ResponseEntity.ok(listaDeAutoresOutput);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AutorOutput> buscaAutorPorId(@PathVariable Long id) {
		AutorEntity autor = autorService.buscaPorId(id);
		AutorOutput autorOutput = autorConvert.entityToOutput(autor);
		return ResponseEntity.ok(autorOutput);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<AutorOutput> alteraAutor(@PathVariable Long id, @RequestBody @Valid EditaAutorInput input) {
		AutorEntity autor = autorService.buscaPorId(id);
		AutorEntity autorAlterado = autorService.altera(autor, input);
		AutorOutput autorOutput = autorConvert.entityToOutput(autorAlterado);
		return ResponseEntity.ok(autorOutput);
	}
	
}
