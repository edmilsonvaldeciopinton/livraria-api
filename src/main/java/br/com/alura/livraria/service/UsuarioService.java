package br.com.alura.livraria.service;

<<<<<<< HEAD
import java.util.Random;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d
import java.util.Random;

import javax.transaction.Transactional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d
>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
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

<<<<<<< HEAD
	public Page<UsuarioDto> listar(Pageable paginacao) {
		Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);
		return usuarios.map(a -> modelMapper.map(a, UsuarioDto.class));
	}

	@Transactional
	public UsuarioDto cadastrar(UsuarioFormDto dto) {
=======
<<<<<<< HEAD
	public Page<UsuarioDto> listar(Pageable paginacao) {
		Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);
		return usuarios.map(a -> modelMapper.map(a, UsuarioDto.class));
=======
	public List<UsuarioDto> listar() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(a -> modelMapper.map(a, UsuarioDto.class)).collect(Collectors.toList());
>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d
	}

	@Transactional
	public void cadastrar(UsuarioFormDto dto) {
>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
		Usuario usuario = modelMapper.map(dto, Usuario.class);

		String senha = new Random().nextInt(999999) + "";
		usuario.setSenha(senha);

		usuarioRepository.save(usuario);
<<<<<<< HEAD

		return modelMapper.map(usuario, UsuarioDto.class);
=======
>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5

	}

}
