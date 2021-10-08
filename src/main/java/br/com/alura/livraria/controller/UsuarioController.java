package br.com.alura.livraria.controller;

<<<<<<< HEAD
import java.net.URI;
=======
<<<<<<< HEAD
=======

import java.util.List;
>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5

>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.UsuarioDto;
import br.com.alura.livraria.dto.UsuarioFormDto;
import br.com.alura.livraria.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
<<<<<<< HEAD
	public Page<UsuarioDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
		return service.listar(paginacao);
	}

	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioFormDto dto,
			UriComponentsBuilder uriBuilder) {
		UsuarioDto usuarioDto =  service.cadastrar(dto);
		URI uri = uriBuilder
				.path("/usuarios/{id}")
				.buildAndExpand(usuarioDto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(usuarioDto);
=======
<<<<<<< HEAD
	public Page<UsuarioDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
		return service.listar(paginacao);
=======
	public List<UsuarioDto> listar() {
		return service.listar();
>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d
	}

	@PostMapping
	public void cadastrar(@RequestBody @Valid UsuarioFormDto dto) {
		service.cadastrar(dto);

>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
	}

}
