package br.com.acelera.biblioteca.restControllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acelera.biblioteca.converts.LivroConvert;
import br.com.acelera.biblioteca.dto.inputs.EditaLivroInput;
import br.com.acelera.biblioteca.dto.inputs.LivroInput;
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
	public LivroEntity insereAutor(@RequestBody @Valid LivroInput livroInput) {
		LivroEntity livro = livroConvert.inputToEntity(livroInput);
		LivroEntity livroCriado = livroService.insere(livro);
		return livroCriado;
	}
	
	@GetMapping
	public List<LivroEntity> listaLivros() {
		List<LivroEntity> listaDeLivros = livroService.listaTodos();
		return listaDeLivros;
	}
	
	@GetMapping("{id}")
	public LivroEntity buscaLivroPorId(@PathVariable Long id) {
		LivroEntity livro = livroService.buscaPorId(id);
		return livro;
	}
	
	@DeleteMapping("{id}")
	public void deletaLivro(@PathVariable Long id) {
		System.out.println("Deletando o livro de id " + id);
		LivroEntity livro = livroService.buscaPorId(id);
		livroService.deleta(livro);
	}
	
	@PutMapping("{id}")
	public LivroEntity alteraLivro(@PathVariable Long id, @RequestBody @Valid EditaLivroInput input) {
		LivroEntity livro = livroService.buscaPorId(id);
//		LivroEntity livroParaAlterar = livroConvert.alteraInputToEntity(input);
		LivroEntity livroAlterado = livroService.altera(livro, input);
		return livroAlterado;
	}
	
}
