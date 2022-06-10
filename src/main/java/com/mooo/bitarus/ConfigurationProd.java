package com.mooo.bitarus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ConfigurationProd {

    @Bean
    public HelloService helloService() {
        System.out.println("### Created HelloService");
        return new HelloService();
    }
}
