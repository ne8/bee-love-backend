package ro.ccpatrut.beelove.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String REST_CONTROLERS_LOCATION = "ro.ccpatrut.beelove.api";

    @Bean
    public Docket api() {
        return
                new Docket(DocumentationType.SWAGGER_2)
                        .groupName("bee-love")
                        .select()
                        .apis(RequestHandlerSelectors.basePackage(
                                REST_CONTROLERS_LOCATION
                        ))
                        .paths(PathSelectors.any())
                        .build()
                        .apiInfo(SwaggerConfiguration.apiInfo("Bee love", "Stuco"));
    }

    private static ApiInfo apiInfo(final String title, final String description) {
        final Contact contact = new Contact("Catalin Patrut", "",
                "ccpatrut@gmail.com");
        return new ApiInfo(title, description, "1.0", "terms of controller url",
                contact, "license", "license url");
    }
}
