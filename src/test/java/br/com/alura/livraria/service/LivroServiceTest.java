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

	@Test
	void deveriaCadastrarUmLivro() {
		LivroFormDto FormLivroDto = new LivroFormDto("E o Vento Levou", LocalDate.now(), 100, 1l);

		LivroDto dto = service.cadastrar(FormLivroDto);

		Mockito.verify(livroRepository.save(Mockito.any()));

		assertEquals(FormLivroDto.getTitulo(), dto.getTitulo());
		assertEquals(FormLivroDto.getDataLancamento(), dto.getDataLancamento());
		assertEquals(FormLivroDto.getNumeroPaginas(), dto.getNumeroPaginas());
	}

	@Test
	void naodeveriaCadastrarUmLivroComAutorInexistente() {
		LivroFormDto FormLivroDto = new LivroFormDto("E o Vento Levou", LocalDate.now(), 100, 1l);

		Mockito.when(autorRepository.getById(FormLivroDto.getAutorId())).thenThrow(EntityNotFoundException.class);

		assertThrows(IllegalArgumentException.class, () -> service.cadastrar(FormLivroDto));
	}

}
