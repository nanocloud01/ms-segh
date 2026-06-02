package bo.gob.sigep.seg.bootstrap.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "SIGEP API",
                version = "1.0.0",
                description = "API REST para la gestión del sistema de Seguridad"
        ),
        servers = {
                @Server(url = "/api", description = "Servidor con context-path /api")
        }
)
public class OpenApiConfig {
}
