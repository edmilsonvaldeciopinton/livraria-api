package br.com.alura.livraria.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.livraria.modelo.Autor;
import br.com.alura.livraria.modelo.Livro;
import br.com.alura.livraria.modelo.Usuario;

class CalculadoraDeImpostoLivroServiceTest {

	@Test
	void livroComTotalDePaginasIsentasDeImposto() {

		Livro livro = new Livro(1l, "E o Vento Levou", LocalDate.now(), 10, new Autor(1l, "Fulano", "fulano@gmail.com",
				"1960-01-21", "Analista de RH", new Usuario(1l, "Rafaela", "rafa@email.com", "123456")));
		CalculadoraDeImpostoLivroService calculadora = new CalculadoraDeImpostoLivroService();
		BigDecimal imposto = calculadora.calcularImpostoLivro(livro);
		assertEquals(BigDecimal.ZERO, imposto);
	}

	@Test
	void livroComImpostoMenorQueDuasMilPaginas() {

		Livro livro = new Livro(1l, "E o Vento Levou", LocalDate.now(), 1000,
				new Autor(1l, "Fulano", "fulano@gmail.com", "1960-01-21", "Analista de RH",
						new Usuario(1l, "Rafaela", "rafa@email.com", "123456")));
		CalculadoraDeImpostoLivroService calculadora = new CalculadoraDeImpostoLivroService();
		BigDecimal imposto = calculadora.calcularImpostoLivro(livro);
		assertEquals(BigDecimal.valueOf(10), imposto);
	}

	@Test
	void livroComImpostoMaiorQueDuasMilPaginas() {

		Livro livro = new Livro(1l, "E o Vento Levou", LocalDate.now(), 2000,
				new Autor(1l, "Fulano", "fulano@gmail.com", "1960-01-21", "Analista de RH",
						new Usuario(1l, "Rafaela", "rafa@email.com", "123456")));
		CalculadoraDeImpostoLivroService calculadora = new CalculadoraDeImpostoLivroService();
		BigDecimal imposto = calculadora.calcularImpostoLivro(livro);
		assertEquals(BigDecimal.valueOf(20), imposto);
	}
}
