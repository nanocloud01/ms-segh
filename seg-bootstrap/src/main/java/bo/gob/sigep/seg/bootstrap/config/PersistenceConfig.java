package bo.gob.sigep.seg.bootstrap.config;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
        "bo.gob.sigep.seg.perfiles.infrastructure.persistence",
        "bo.gob.sigep.seg.usuarios.infrastructure.persistence",
        "bo.gob.sigep.seg.accesos.infrastructure.persistence"
})
@EntityScan(basePackages = {
        "bo.gob.sigep.seg.perfiles.infrastructure.persistence",
        "bo.gob.sigep.seg.usuarios.infrastructure.persistence",
        "bo.gob.sigep.seg.accesos.infrastructure.persistence"
})
public class PersistenceConfig {
}
