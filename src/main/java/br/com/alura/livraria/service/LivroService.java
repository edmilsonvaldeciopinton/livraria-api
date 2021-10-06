package br.com.alura.livraria.service;

<<<<<<< HEAD
=======
import java.util.List;
import java.util.stream.Collectors;

>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d
import org.springframework.stereotype.Service;

import br.com.alura.livraria.dto.LivroDto;
import br.com.alura.livraria.dto.LivroFormDto;
import br.com.alura.livraria.modelo.Livro;
import br.com.alura.livraria.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	private ModelMapper modelMapper = new ModelMapper();

<<<<<<< HEAD
	public Page<LivroDto> listar(Pageable paginacao) {
		Page<Livro> livros = livroRepository.findAll(paginacao);
		return livros.map(a -> modelMapper.map(a, LivroDto.class));
=======
	public List<LivroDto> listar() {
		List<Livro> livros = livroRepository.findAll();
		return livros.stream().map(a -> modelMapper.map(a, LivroDto.class)).collect(Collectors.toList());
>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d
	}

	@Transactional
	public void cadastrar(LivroFormDto dto) {
		Livro livro = modelMapper.map(dto, Livro.class);
		livroRepository.save(livro);

	}

}
