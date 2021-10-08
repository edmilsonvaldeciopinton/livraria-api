package br.com.alura.livraria.service;

<<<<<<< HEAD
=======
<<<<<<< HEAD
import javax.transaction.Transactional;
=======
import java.util.List;
import java.util.stream.Collectors;
>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d

>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d
>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
import org.springframework.stereotype.Service;

import br.com.alura.livraria.dto.AutorDto;
import br.com.alura.livraria.dto.AutorFormDto;
import br.com.alura.livraria.dto.LivroDto;
import br.com.alura.livraria.modelo.Autor;
import br.com.alura.livraria.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	private ModelMapper modelMapper = new ModelMapper();

<<<<<<< HEAD
	public Page<AutorDto> listar(Pageable paginacao) {
		Page<Autor> autores = autorRepository.findAll(paginacao);
		return autores.map(a -> modelMapper.map(a, AutorDto.class));
	}

	@Transactional
	public AutorDto cadastrar(AutorFormDto dto) {
		Autor autor = modelMapper.map(dto, Autor.class);
		autor.setId(null);
		autorRepository.save(autor);
		return modelMapper.map(autor, AutorDto.class);
=======
<<<<<<< HEAD
	public Page<AutorDto> listar(Pageable paginacao) {
		Page<Autor> autores = autorRepository.findAll(paginacao);
		return autores.map(a -> modelMapper.map(a, AutorDto.class));
=======
	public List<AutorDto> listar() {
		List<Autor> autores = autorRepository.findAll();
		return autores.stream().map(a -> modelMapper.map(a, AutorDto.class)).collect(Collectors.toList());
>>>>>>> 778f5c028cd2d9b914ed26c12ba75f00d1fe9e9d
	}

	@Transactional
	public void cadastrar(AutorFormDto dto) {
		Autor autor = modelMapper.map(dto, Autor.class);
		autor.setId(null);
		autorRepository.save(autor);
>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
	}
}
