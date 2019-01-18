package com.vasu.SpringBootStripeCheckout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootStripeCheckoutApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
        return app.sources(SpringBootStripeCheckoutApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStripeCheckoutApplication.class, args);
    }

}
