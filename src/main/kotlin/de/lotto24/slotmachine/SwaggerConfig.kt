package de.lotto24.slotmachine

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Enables Swagger support. Start application and call http://localhost:8080/
 */
@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Value("\${application.swagger.title}")
    lateinit var title: String

    @Value("\${application.swagger.description}")
    lateinit var description: String

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                // only /api/** methods should be exposed by Swagger
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .useDefaultResponseMessages(false)
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title(title)
                .description(description)
                .build()
    }
}