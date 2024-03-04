package org.megatouch.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class PersistentConfig {


    @Bean
    AuditorAware<String> auditorProvider() {
        return () -> Optional.of("admin");
    }

}
