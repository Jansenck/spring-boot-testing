package dio.aulas.doc;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Open API")
                        .description("Api for testing OpenApi")
                        .contact(new Contact().name("Jansen Ferreira").email("jansen@email.com"))
                        .version("1.0.0")
                );
    }
}
