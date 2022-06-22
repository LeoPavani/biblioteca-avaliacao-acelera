package br.com.acelera.biblioteca.dto.inputs;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroInput {

	@NotBlank
	String titulo;

	@NotBlank
	@Length(max = 4)
	String anoLancamento;
	
	@NotEmpty
	List<Long> autores;
}
