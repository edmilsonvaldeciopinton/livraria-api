package br.com.alura.livraria.service;

import java.math.BigDecimal;

import br.com.alura.livraria.modelo.Livro;

public class CalculadoraDeImpostoLivroService {

	// Isento de imposto para livros cadastrados com menos de 500 páginas
	// r$ 10.00 de imposto para livros cadastrados com entre 500 a 2000 páginas
	// (inclusive)
	// r$ 20.00 de imposto para livros cadastrados com mais de 2000 páginas.

	public BigDecimal calcularImpostoLivro(Livro livro) {
		if (livro.getNumeroPaginas() < 500) {
			return BigDecimal.ZERO;
		}
		if (livro.getNumeroPaginas() < 2000) {
			return new BigDecimal(10.00);
		}
		return new BigDecimal(20.00);
	}
}
