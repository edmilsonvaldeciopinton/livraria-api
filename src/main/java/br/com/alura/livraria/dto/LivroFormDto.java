package br.com.alura.livraria.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroFormDto {

	@NotBlank
	@Size(min = 10)
	private String titulo;

	@PastOrPresent
	@Column(name="data_lancamento")
	private LocalDate dataLancamento;

	@Min(100)
	private int numeroPaginas;

	private String autor;
	
	@JsonAlias("usuario_id")
	private Long usuarioId;

}
