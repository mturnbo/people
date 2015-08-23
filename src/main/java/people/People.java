package people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 *  People API Application
 *
 *  @author Marcus Turnbo
 */

@SpringBootApplication
public class People extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(People.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(People.class, args);
    }

}
