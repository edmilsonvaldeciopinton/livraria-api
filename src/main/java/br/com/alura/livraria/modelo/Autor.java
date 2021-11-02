package br.com.alura.livraria.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;

	@Column(name = "datanascimento")
	private LocalDate dataNascimento;

	@Column(name = "minicurriculum")
	private String miniCurriculum;

	@ManyToOne
	private Usuario usuario;

	public Autor(String nome, String email, LocalDate dataNascimento, String miniCurriculum, Usuario usuario) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.miniCurriculum = miniCurriculum;
		this.usuario = usuario;
	}

	public void atualizarInformacoes(String nome, String email, LocalDate dataNascimento, String miniCurriculum) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.miniCurriculum = miniCurriculum;
	}

	public boolean pertenceAoUsuario(Usuario usuario) {
		return this.usuario.equals(usuario);
	}
}
