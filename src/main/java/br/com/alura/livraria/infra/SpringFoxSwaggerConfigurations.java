package br.com.alura.livraria.infra;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxSwaggerConfigurations {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("API Cadastro de Autores e Livros", "Projeto Desenvolvido no BootCamp Java da Alura",
				"Termos de Uso", "Termos de Serviço",
				new Contact("Edmilson Valdécio Pinton", "http://localhost:8080/swagger-ui.html#/",
						"edmilson.valdecio.pinton@gmail.com"),
				"License of API", "API license URL", Collections.emptyList());
	}

}
