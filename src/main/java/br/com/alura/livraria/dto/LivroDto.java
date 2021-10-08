package br.com.alura.livraria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDto {

	private Long id;
	private String titulo;
	private int numeroPaginas;
	private String autor;

}
