package br.com.acelera.biblioteca.dto.inputs;

import javax.validation.constraints.AssertTrue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditaAutorInput {

	String nome;
	String biografia;
	
	@AssertTrue
	public boolean isNome() {
		if(this.nome == null) {
			this.nome = "";
		}
		return true;
	}
	
	@AssertTrue
	public boolean isBiografia() {
		if(this.biografia == null) {
			this.biografia = "";
		}
		return true;
	}
}
