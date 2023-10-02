package dio.aulas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AulaSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaSpringDataJpaApplication.class, args);
	}

}
