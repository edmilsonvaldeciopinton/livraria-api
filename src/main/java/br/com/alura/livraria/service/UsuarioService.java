package br.com.alura.livraria.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.livraria.dto.UsuarioDto;
import br.com.alura.livraria.dto.UsuarioFormDto;
import br.com.alura.livraria.modelo.Usuario;
import br.com.alura.livraria.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private ModelMapper modelMapper = new ModelMapper();

	public List<UsuarioDto> listar() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(a -> modelMapper.map(a, UsuarioDto.class)).collect(Collectors.toList());
	}

	@Transactional
	public void cadastrar(UsuarioFormDto dto) {
		Usuario usuario = modelMapper.map(dto, Usuario.class);

		String senha = new Random().nextInt(999999) + "";
		usuario.setSenha(senha);

		usuarioRepository.save(usuario);

	}

}
