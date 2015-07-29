package br.comar.ricardo.stuff.nio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringNonBlockingIoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNonBlockingIoApplication.class, args);
    }
}

