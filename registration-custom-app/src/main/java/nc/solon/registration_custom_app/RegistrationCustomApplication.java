package nc.solon.registration_custom_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"nc.solon.registration_custom_app",
		"nc.solon.registration_custom_adapter"
})
@EnableJpaRepositories(basePackages = "nc.solon.registration_custom_adapter.adapter.outbound.persistence.repository")
@EntityScan(basePackages = "nc.solon.registration_custom_adapter.adapter.outbound.persistence.entity")
public class RegistrationCustomApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationCustomApplication.class, args);
	}

}
