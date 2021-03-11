package br.com.cvinicius.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    val info = ApiInfo("Cálculo de IMC", "Aplicação para cálculo do índice de massa corporal.", "1.0.0", null, null, null, null, listOf())

    @Bean
    fun api() = Docket(DocumentationType.OAS_30)
                    .apiInfo(info)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.ant("/imc"))
                    .build()
}