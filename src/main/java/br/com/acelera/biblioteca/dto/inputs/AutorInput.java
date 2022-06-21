package br.com.acelera.biblioteca.dto.inputs;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorInput {

	@NotBlank
	String nome;
	
	@NotBlank
	String biografia;
}
