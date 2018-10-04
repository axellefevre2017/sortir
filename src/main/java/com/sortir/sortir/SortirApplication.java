package com.sortir.sortir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Locale;

@SpringBootApplication
public class SortirApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SortirApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SortirApplication.class, args);
        Locale.setDefault(new Locale("en", "US"));
    }
}
