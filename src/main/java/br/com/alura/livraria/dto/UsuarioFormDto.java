package br.com.alura.livraria.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioFormDto {

	@NotBlank
	private String nome;

	@NotBlank
	private String login;

}
