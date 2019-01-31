package app.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Black on 11.02.2018.
 */

@ComponentScan("app")
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(Application.class, args);
/*
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }*/
    }
}

