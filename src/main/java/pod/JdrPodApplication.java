package pod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"api", "service", "configuration", "repository", "mapper"})
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "entity")
public class JdrPodApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdrPodApplication.class, args);
    }

}
