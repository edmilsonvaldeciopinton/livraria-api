package br.com.alura.livraria.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.alura.livraria.modelo.Autor;
import br.com.alura.livraria.modelo.Usuario;

class CalculadoraDeImpostoAutorServiceTest {

	@Test
	void pagamentoDeImpostoParaDoacao() {
		Autor autor = new Autor(120l, "Fulano", "fulano@gmail.com", "1960-01-21", "Analista de RH",
				new Usuario(1l, "Rafaela", "rafa@email.com", "123456"));

		CalculadoraDeImpostoAutorService calculadoraDeImpostoAutor = new CalculadoraDeImpostoAutorService();
		BigDecimal impostoDoacao = calculadoraDeImpostoAutor.calcularImpostoAutor(autor);
		assertEquals(BigDecimal.valueOf(1), impostoDoacao);

	}

}
