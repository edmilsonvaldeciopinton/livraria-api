package br.com.alura.livraria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemLivroDto {

	private String autor;
	private Long quantidade;
	private Double percentual;

}
