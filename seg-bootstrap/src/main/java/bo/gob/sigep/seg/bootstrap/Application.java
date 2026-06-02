package bo.gob.sigep.seg.bootstrap;

import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Clase principal de la aplicación SEG API.
 *
 * Configuración de acceso a Swagger/OpenAPI:
 * - Swagger UI: http://localhost:7171/swagger-ui.html
 * - OpenAPI JSON: http://localhost:7171/v3/api-docs
 * - OpenAPI YAML: http://localhost:7171/v3/api-docs.yaml
 *
 * Nota: Las URLs anteriores usan el context-path '/api' configurado en application.properties
 * Si deseas acceder sin context-path, usa:
 * - http://localhost:7171/api/swagger-ui.html
 * - http://localhost:7171/api/v3/api-docs
 */
@SpringBootApplication(scanBasePackages = "bo.gob.sigep")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner debugBeans(ApplicationContext ctx) {
        return args -> {
            System.out.println("UserRepository beans:");
            for (String name : ctx.getBeanNamesForType(UserRepository.class)) {
                System.out.println(name);
            }
        };
    }
}
