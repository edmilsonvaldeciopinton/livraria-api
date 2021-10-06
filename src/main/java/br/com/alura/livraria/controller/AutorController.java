package br.com.alura.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;
import br.com.alura.livraria.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorService service;

	@GetMapping
<<<<<<< HEAD
	public Page<AutorDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
		return service.listar(paginacao);
=======
	public List<AutorDto> listar() {
		return service.listar();
>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d

	}

	@PostMapping
	public void cadastrar(@RequestBody @Valid AutorFormDto dto) {
		service.cadastrar(dto);

	}

}
