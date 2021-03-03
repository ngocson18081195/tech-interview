package techbase.interview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * Description:
 * The AuditingConfig class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditingConfig {
    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.ofNullable(null);
    }
}

class SpringSecurityAuditAware implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.ofNullable(null);
    }
}
