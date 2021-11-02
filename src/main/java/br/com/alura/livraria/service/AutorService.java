package br.com.alura.livraria.service;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.livraria.dto.AtualizacaoAutorFormDto;
import br.com.alura.livraria.dto.AutorDetalhadaDto;
import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;
import br.com.alura.livraria.modelo.Autor;
import br.com.alura.livraria.modelo.Usuario;
import br.com.alura.livraria.repository.AutorRepository;
import br.com.alura.livraria.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Page<AutorDto> listar(Pageable paginacao, Usuario usuario) {
		return autorRepository.findAllByUsuario(paginacao, usuario).map(a -> modelMapper.map(a, AutorDto.class));
//		Page<Autor> autores = autorRepository.findAllByUsuario(paginacao, usuario);
//		return autores.map(a -> modelMapper.map(a, AutorDto.class));
	}

	@Transactional
	public AutorDto cadastrar(AutorFormDto dto, Usuario logado) {
		Long idUsuario = dto.getUsuarioId();

		try {
			Usuario usuario = usuarioRepository.getById(idUsuario);

			if (!usuario.equals(logado)) {
				lancarErroAcessoNegado();
			}

			Autor autor = modelMapper.map(dto, Autor.class);
			autor.setId(null);
			autorRepository.save(autor);
			return modelMapper.map(autor, AutorDto.class);
		} catch (EntityNotFoundException e) {
			throw new IllegalArgumentException("usuario inexistente");

		}
	}

	@Transactional
	public AutorDto atualizar(AtualizacaoAutorFormDto dto, Usuario logado) {
		Autor autor = autorRepository.getById(dto.getId());

		if (!autor.pertenceAoUsuario(logado)) {
			lancarErroAcessoNegado();
		}

		autor.atualizarInformacoes(dto.getNome(), dto.getEmail(), dto.getDataNascimento(), dto.getMiniCurriculum());
		return modelMapper.map(autor, AutorDto.class);
	}

	@Transactional
	public void remover(Long id, Usuario logado) {
		Autor autor = autorRepository.getById(id);
		if (!autor.pertenceAoUsuario(logado)) {
			lancarErroAcessoNegado();
		}
		autorRepository.deleteById(id);

	}

	public AutorDetalhadaDto detalhar(Long id, Usuario logado) {
		Autor autor = autorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

		if (!autor.pertenceAoUsuario(logado)) {
			lancarErroAcessoNegado();
		}

		return modelMapper.map(autor, AutorDetalhadaDto.class);
	}

	private void lancarErroAcessoNegado() {
		throw new AccessDeniedException("Acesso Negado!");
	}

}
