package br.com.alura.livraria.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.livraria.dto.AtualizacaoAutorFormDto;
import br.com.alura.livraria.dto.AutorDetalhadaDto;
import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;
import br.com.alura.livraria.modelo.Usuario;
import br.com.alura.livraria.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorService service;

	@GetMapping
	public Page<AutorDto> listar(@PageableDefault(size = 10) Pageable paginacao,
			@AuthenticationPrincipal Usuario logado) {
		return service.listar(paginacao, logado);
	}

	@PostMapping
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorFormDto dto, UriComponentsBuilder uriBuilder,
			@AuthenticationPrincipal Usuario logado) {
		AutorDto autorDto = service.cadastrar(dto, logado);

		URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autorDto.getId()).toUri();

		return ResponseEntity.created(uri).body(autorDto);

	}

	@PutMapping
	public ResponseEntity<AutorDto> atualizar(@RequestBody @Valid AtualizacaoAutorFormDto dto,
			@AuthenticationPrincipal Usuario logado) {
		AutorDto atualizada = service.atualizar(dto, logado);
		return ResponseEntity.ok(atualizada);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<AutorDto> remover(@PathVariable @NotNull Long id, @AuthenticationPrincipal Usuario logado) {
		service.remover(id, logado);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/{id}")
	public ResponseEntity<AutorDetalhadaDto> detalhar(@PathVariable @NotNull Long id,
			@AuthenticationPrincipal Usuario logado) {
		AutorDetalhadaDto dto = service.detalhar(id, logado);
		return ResponseEntity.ok(dto);

	}

}
