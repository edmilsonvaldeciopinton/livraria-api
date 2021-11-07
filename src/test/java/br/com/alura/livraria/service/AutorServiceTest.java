package br.com.alura.livraria.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;
import br.com.alura.livraria.modelo.Autor;
import br.com.alura.livraria.modelo.Usuario;
import br.com.alura.livraria.repository.AutorRepository;
import br.com.alura.livraria.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
class AutorServiceTest {

	@Mock
	private AutorRepository autorRepository;

	@Mock
	private UsuarioRepository usuarioRepository;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	private AutorService service;

	private Usuario logado;

	@BeforeEach
	public void before() {
		this.logado = new Usuario("Rodrigo", "rodrigo@email.com", "123456");
	}

	private AutorFormDto criarAutorFormDto() {
		AutorFormDto formAutorDto = new AutorFormDto("Fulano", "fulano@gmail.com", LocalDate.now(), "Escritor", 1l);
		return formAutorDto;
	}

	@Test
	void deveriaCadastrarUmAutor() {
		AutorFormDto formAutorDto = criarAutorFormDto();

		Mockito.when(usuarioRepository.getById(formAutorDto.getUsuarioId())).thenReturn(logado);

		Autor autor = new Autor(formAutorDto.getNome(), formAutorDto.getEmail(), formAutorDto.getDataNascimento(),
				formAutorDto.getMiniCurriculum(), logado);
		Mockito.when(modelMapper.map(formAutorDto, Autor.class)).thenReturn(autor);

		Mockito.when(modelMapper.map(autor, AutorDto.class)).thenReturn(new AutorDto(null, autor.getNome(),
				autor.getEmail(), autor.getDataNascimento(), autor.getMiniCurriculum()));

		AutorDto dto = service.cadastrar(formAutorDto, logado);

		Mockito.verify(autorRepository).save(Mockito.any());

		assertEquals(formAutorDto.getNome(), dto.getNome());
		assertEquals(formAutorDto.getEmail(), dto.getEmail());
		assertEquals(formAutorDto.getDataNascimento(), dto.getDataNascimento());
		assertEquals(formAutorDto.getMiniCurriculum(), dto.getMiniCurriculum());

	}

	@Test
	void naodeveriaCadastrarUmAutorComUsuarioInexixtente() {
		AutorFormDto formAutorDto = criarAutorFormDto();

		Mockito.when(usuarioRepository.getById(formAutorDto.getUsuarioId())).thenThrow(EntityNotFoundException.class);

		assertThrows(IllegalArgumentException.class, () -> service.cadastrar(formAutorDto, logado));

	}

}
