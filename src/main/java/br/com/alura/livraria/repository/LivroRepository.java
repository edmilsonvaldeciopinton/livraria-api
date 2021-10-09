package br.com.alura.livraria.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.livraria.dto.ItemLivroDto;
import br.com.alura.livraria.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {


	@Query("select new br.com.alura.livraria.dto.ItemLivroDto(  " 
			+ "t.autor, "
			+ "count(t.autor), "
			+ "count(t.autor) * 1.0 / (select count(t2.autor) from Livro t2) * 1.0)"	
			+ " from Livro "
			+ " group by t.autor")	
	List<ItemLivroDto> relatorioQuantidadeDeLivros();
	


}
