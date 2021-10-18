package br.com.alura.livraria.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.livraria.dto.LivroDto;
import br.com.alura.livraria.dto.LivroFormDto;
import br.com.alura.livraria.repository.AutorRepository;
import br.com.alura.livraria.repository.LivroRepository;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {

	@Mock
	private LivroRepository livroRepository;

	@Mock
	private AutorRepository autorRepository;

	@InjectMocks
	private LivroService service;

	private LivroFormDto criarLivroFormDto() {
		LivroFormDto formLivroDto = new LivroFormDto("E o Vento Levou", LocalDate.now(), 100, 1l);
		return formLivroDto;
	}

	@Test
	void deveriaCadastrarUmLivro() {
		LivroFormDto formLivroDto = criarLivroFormDto();

		LivroDto dto = service.cadastrar(formLivroDto);

		Mockito.verify(livroRepository.save(Mockito.any()));

		assertEquals(formLivroDto.getTitulo(), dto.getTitulo());
		assertEquals(formLivroDto.getDataLancamento(), dto.getDataLancamento());
		assertEquals(formLivroDto.getNumeroPaginas(), dto.getNumeroPaginas());

	}

	@Test
	void naodeveriaCadastrarUmLivroComAutorInexistente() {
		LivroFormDto formLivroDto = criarLivroFormDto();

		Mockito.when(autorRepository.getById(formLivroDto.getAutorId())).thenThrow(EntityNotFoundException.class);

		assertThrows(IllegalArgumentException.class, () -> service.cadastrar(formLivroDto));

	}

}
