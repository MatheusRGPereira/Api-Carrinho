package com.gama.carrinho.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springSustechOpenAPI() {
		return new OpenAPI()
				.info(new Info()
					.title("Projeto Carrinho")
					.description("Projeto Carrinho - Codigo do futuro")
					.version("v0.0.1")
				.license(new License()
					.name("Gama Academy")
					.url("https://www.gama.academy/?&utm_source=google&utm_medium=paid-search&utm_campaign=brand-awareness&utm_term=gama-academy&gclid=CjwKCAiAyfybBhBKEiwAgtB7fqe2g_ZF01k191KdAdTFakpOrIHQSto2pAThoMZJY9Jv9lEPCrNdVBoCOdMQAvD_BwE"))
				.contact(new Contact()
					.name("Carrinho")
					.url("https://github.com/MatheusRGPereira")
					.email("matheusgaldinoinfo@gmail.com")))
				.externalDocs(new ExternalDocumentation()
					.description("Github")
					.url("https://github.com/MatheusRGPereira"));
	}

	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {

		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

			}));
		};
	}

	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);

	}
	
}