package br.com.acelera.biblioteca.restControllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.acelera.biblioteca.converts.LivroConvert;
import br.com.acelera.biblioteca.dto.inputs.EditaLivroInput;
import br.com.acelera.biblioteca.dto.inputs.LivroInput;
import br.com.acelera.biblioteca.dto.outputs.LivroOutput;
import br.com.acelera.biblioteca.entities.LivroEntity;
import br.com.acelera.biblioteca.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroConvert livroConvert;
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping
	public ResponseEntity<LivroOutput> insereLivro(@RequestBody @Valid LivroInput livroInput, UriComponentsBuilder uriBuilder) {
		LivroEntity livro = livroConvert.inputToEntity(livroInput);
		LivroEntity livroCriado = livroService.insere(livro);
		LivroOutput livroOutput = livroConvert.entityToOutput(livroCriado);
		URI uri = uriBuilder.path("api/livros/{id}").buildAndExpand(livroOutput.getId()).toUri();
		
		
		return ResponseEntity.created(uri).body(livroOutput);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroOutput>> listaLivros() {
		List<LivroEntity> listaDeLivros = livroService.listaTodos();
		List<LivroOutput> listaDeLivrosOutput = livroConvert.entityListToOutputList(listaDeLivros);
		return ResponseEntity.ok(listaDeLivrosOutput);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<LivroOutput> buscaLivroPorId(@PathVariable Long id) {
		LivroEntity livro = livroService.buscaPorId(id);
		LivroOutput livroOutput = livroConvert.entityToOutput(livro);
		return ResponseEntity.ok(livroOutput);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletaLivro(@PathVariable Long id) {
		System.out.println("Deletando o livro de id " + id);
		LivroEntity livro = livroService.buscaPorId(id);
		livroService.deleta(livro);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<LivroOutput> alteraLivro(@PathVariable Long id, @RequestBody @Valid EditaLivroInput input) {
		LivroEntity livro = livroService.buscaPorId(id);
//		LivroEntity livroParaAlterar = livroConvert.alteraInputToEntity(input);
		LivroEntity livroAlterado = livroService.altera(livro, input);
		LivroOutput livroOutput = livroConvert.entityToOutput(livroAlterado);
		return ResponseEntity.ok(livroOutput);
	}
	
	@GetMapping("busca-por-autor/{idAutor}")
	public ResponseEntity<List<LivroOutput>> buscaLivrosPorAutor(@PathVariable Long idAutor) {
		List<LivroEntity> livrosDoAutor = livroService.buscaPorIdDoAutor(idAutor);
		List<LivroOutput> livrosDoAutorOutput = livroConvert.entityListToOutputList(livrosDoAutor);
		return ResponseEntity.ok(livrosDoAutorOutput);
	}
	
}
