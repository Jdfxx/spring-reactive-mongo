package pl.filiphagno.springreactivemongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringReactiveMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveMongoApplication.class, args);
    }

}
