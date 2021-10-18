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

import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;
import br.com.alura.livraria.repository.AutorRepository;
import br.com.alura.livraria.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
class AutorServiceTest {

	@Mock
	private AutorRepository autorRepository;

	@Mock
	private UsuarioRepository usuarioRepository;

	@InjectMocks
	private AutorService service;
	
	private AutorFormDto criarAutorFormDto() {
		AutorFormDto formAutorDto = new AutorFormDto("Fulano", "fulano@gmail.com", LocalDate.now(), "Escritor", 1l);
		return formAutorDto;
	}

	@Test
	void deveriaCadastrarUmAutor() {
		AutorFormDto formAutorDto = criarAutorFormDto();

		AutorDto dto = service.cadastrar(formAutorDto);
		
		Mockito.verify(autorRepository.save(Mockito.any()));

		assertEquals(formAutorDto.getNome(), dto.getNome());
		assertEquals(formAutorDto.getEmail(), dto.getEmail());
		assertEquals(formAutorDto.getDataNascimento(), dto.getDataNascimento());
		assertEquals(formAutorDto.getMiniCurriculum(), dto.getMiniCurriculum());

	}

	@Test
	void naodeveriaCadastrarUmAutorComUsuarioInexixtente() {
		AutorFormDto formAutorDto = criarAutorFormDto();

		Mockito.when(usuarioRepository.getById(formAutorDto.getUsuarioId())).thenThrow(EntityNotFoundException.class);

		assertThrows(IllegalArgumentException.class, () -> service.cadastrar(formAutorDto));

	}

}
