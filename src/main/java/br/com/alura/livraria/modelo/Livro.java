package br.com.alura.livraria.modelo;

import java.time.LocalDate;

<<<<<<< HEAD
import javax.persistence.Column;
=======
>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = { "dataLancamento" })
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	
	@Column(name = "datalancamento")
	private LocalDate dataLancamento;
<<<<<<< HEAD
	
	@Column(name = "numeropaginas")	
	private Integer numeroPaginas;
	
=======
	private Integer numeroPaginas;
>>>>>>> 40a9978bbe3c1718fd395f7f15c50f7ab02105a5
	private String autor;

}
