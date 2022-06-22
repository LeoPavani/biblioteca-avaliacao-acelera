package br.com.acelera.biblioteca.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_livros")
public class LivroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	
	@Column(name = "titulo", length = 200)
	String titulo;
	
	@Column(name = "ano_lancamento", length = 4)
	String anoLancamento;
	
	@ManyToMany
	@JoinTable(name = "tb_livros_autores", joinColumns = @JoinColumn(name = "livro_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id"))
	List<AutorEntity> autores;
}
