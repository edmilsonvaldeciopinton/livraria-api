package br.com.alura.livraria.service;

import java.math.BigDecimal;

import br.com.alura.livraria.modelo.Autor;

public class CalculadoraDeImpostoAutorService {

	// Pagamento de R$ 1,00 de Imposto a titulo de doação para cada Autor
	// Cadastrado
	public BigDecimal calcularImpostoAutor(Autor autor) {
		return new BigDecimal(1.00);
	}
}
