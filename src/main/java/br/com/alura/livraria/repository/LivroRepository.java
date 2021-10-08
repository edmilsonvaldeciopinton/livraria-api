package br.com.alura.livraria.repository;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.livraria.dto.ItemLivroDto;
=======
import org.springframework.data.jpa.repository.JpaRepository;

>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
import br.com.alura.livraria.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

<<<<<<< HEAD
	@Query("select new br.com.alura.livraria.dto.ItemLivroDto(  " 
	+ "t.autor, " 
	+ "count(t.autor), count(t.autor) * 1.0 / (select count(t2.autor)  "
	+ "from Livro t2) * 1.0) from Livro t " 
	+ "group by t.autor")
	List<ItemLivroDto> relatorioQuantidadeDeLivros();
	

=======
>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
}
