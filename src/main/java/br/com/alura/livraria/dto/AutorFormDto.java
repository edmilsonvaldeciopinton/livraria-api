package br.com.alura.livraria.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorFormDto {
	@NotBlank
	@NotEmpty
	private String nome;
	
	@NotBlank
	@NotEmpty
	@Email
	private String email;


	@Past
	private LocalDate dataNascimento;
	
	@NotBlank
	@NotEmpty
	@Size(min = 5, max = 100)
	private String miniCurriculum;
}
