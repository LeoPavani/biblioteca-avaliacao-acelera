package br.com.acelera.biblioteca.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acelera.biblioteca.converts.AutorConvert;
import br.com.acelera.biblioteca.dto.inputs.AutorInput;
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
	public AutorEntity insereAutor(@RequestBody AutorInput autorInput) {
		AutorEntity autor = autorConvert.inputToEntity(autorInput);
		AutorEntity autorCriado = autorService.insere(autor);
		return autorCriado;
	}
}
