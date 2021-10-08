package br.com.alura.livraria.controller;

import java.net.URI;

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

import br.com.alura.livraria.dto.LivroDto;
import br.com.alura.livraria.dto.LivroFormDto;
import br.com.alura.livraria.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService service;

	@GetMapping
<<<<<<< HEAD
	public Page<LivroDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
		return service.listar(paginacao);
=======
<<<<<<< HEAD
	public Page<LivroDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
		return service.listar(paginacao);
=======
	public List<LivroDto> listar() {
		return service.listar();
>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d
>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
	}

	@PostMapping
	public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroFormDto dto, UriComponentsBuilder uriBuilder) {
		LivroDto livroDto = service.cadastrar(dto);
		URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livroDto.getId()).toUri();
		return ResponseEntity.created(uri).body(livroDto);
	}

}
