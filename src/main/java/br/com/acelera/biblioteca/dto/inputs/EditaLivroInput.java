package br.com.acelera.biblioteca.dto.inputs;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditaLivroInput {

	
	String titulo;

	@Length(max = 4, min = 4)
	String anoLancamento;

	List<Long> autores;
	
	@AssertTrue
	public boolean isTitulo() {
		if(this.titulo == null) {
			this.titulo = "";
		}
		return true;
	}
	
	@AssertTrue
	public boolean isAnoLancamento() {
		if(this.anoLancamento == null) {
			this.anoLancamento = "";
		}
		return true;
	}
	@AssertTrue
	public boolean isAutores() {
		if(this.autores == null) {
			this.autores = new ArrayList<>();
		}
		return true;
	}
	
	
}
