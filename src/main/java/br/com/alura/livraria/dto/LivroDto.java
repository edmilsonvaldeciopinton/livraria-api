package br.com.alura.livraria.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroDto {

	private Long id;
	private String titulo;
	private LocalDate dataLancamento;
	private Integer numeroPaginas;
	// private String autor;
	private AutorDto autor;

}
