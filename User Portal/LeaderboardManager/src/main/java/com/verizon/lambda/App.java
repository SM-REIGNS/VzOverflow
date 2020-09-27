package com.verizon.lambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.verizon")
@EnableMongoRepositories("com.verizon")
public class App {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class);


    }
}
