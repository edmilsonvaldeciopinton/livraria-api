package br.com.alura.livraria.repository;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.alura.livraria.dto.ItemLivrariaDto;
import br.com.alura.livraria.modelo.Autor;
import br.com.alura.livraria.modelo.Livro;
import br.com.alura.livraria.modelo.Usuario;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class LivroRepositoryTest {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private TestEntityManager em;

	@Test
	void deveriaRetornarRelatorioQuantidadeDeLivrosPorAutor() {

		Usuario usuario = new Usuario("Rafaela", "rafa@email.com", "123456");
		em.persist(usuario);

		Autor a1 = new Autor("Andre da Silva", "andresilva@gmail.com", LocalDate.now(), "Escritor", usuario);
		em.persist(a1);
		Autor a2 = new Autor("Fernanda Nogueira", "fernandan@gmail.com", LocalDate.now(), "Escritora", usuario);
		em.persist(a2);
		Autor a3 = new Autor("Juliana Carvalho", "julianac@gmail.com", LocalDate.now(), "Escritora", usuario);
		em.persist(a3);
		Autor a4 = new Autor("Rita de Assis", "julianac@gmail.com", LocalDate.now(), "Escritora", usuario);
		em.persist(a4);
		Autor a5 = new Autor("Rodrigo de Souza", "rodrigos@gmail.com", LocalDate.now(), "Escritora", usuario);
		em.persist(a5);

		Livro t1 = new Livro("Aprenda java em 21 dias", LocalDate.now(), 100, a1);
		em.persist(t1);
		Livro t2 = new Livro("Como ser mais produtivo", LocalDate.now(), 100, a2);
		em.persist(t2);
		Livro t3 = new Livro("Aprenda a falar em publico", LocalDate.now(), 100, a3);
		em.persist(t3);
		Livro t4 = new Livro("Otimizando o seu Tempo", LocalDate.now(), 100, a2);
		em.persist(t4);
		Livro t5 = new Livro("Como fazer bolos incriveis", LocalDate.now(), 100, a4);
		em.persist(t5);
		Livro t6 = new Livro("Investindo em Ações na Bolsa de Valores", LocalDate.now(), 100, a5);
		em.persist(t6);
		Livro t7 = new Livro("Aprenda Phynton em 12 dias", LocalDate.now(), 100, a1);
		em.persist(t7);

		List<ItemLivrariaDto> relatorio = repository.relatorioLivrosPublicadosPorAutor();

		// assertEquals(5, relatorio.size());
		Assertions
		.assertThat(relatorio)
		.hasSize(5)
		.extracting(ItemLivrariaDto::getAutor, ItemLivrariaDto::getQuantidade, ItemLivrariaDto::getPercentual)
		.containsExactlyInAnyOrder(
				Assertions.tuple("Andre da Silva", 2l, 0.28571),
				Assertions.tuple("Fernanda Nogueira", 2l, 0.28571),
				Assertions.tuple("Juliana Carvalho", 1l, 0.14286),
				Assertions.tuple("Rita de Assis", 1l, 0.14286),
				Assertions.tuple("Rodrigo de Souza", 1l, 0.14286)				
				);


	}

}
