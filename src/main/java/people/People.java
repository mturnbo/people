package people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

/**
 *  People API Application
 *
 *  @author Marcus Turnbo
 */

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
public class People extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(People.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(People.class, args);
    }

}
