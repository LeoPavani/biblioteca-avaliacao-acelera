package br.com.acelera.biblioteca.dto.outputs;

import java.util.List;

import br.com.acelera.biblioteca.entities.AutorEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroOutput {
	Long id;
	String titulo;
	String anoLancamento;
	List<AutorEntity> autores;
}
