package br.com.alura.livraria.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class LivroControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	void naoDeveriaCadastrarLivroComDadosIncompletos() throws Exception {
		String json = "{}";
		mvc.perform(post("/livros").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isBadRequest());

	}

	@Test
	void deveriaCadastrarLivroComDadosCompletos() throws Exception {
		String json = "{\"titulo\":\"fulano\",\"dataLancamento\":\"1960-12-12\",\"numeroPaginas\":\100}";
		mvc.perform(post("/livros").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated());
		// .andExpect(header().exists("Location"))
		// .andExpect(content().json(json));

	}

}
