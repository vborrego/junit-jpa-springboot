package com.mooo.bitarus;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ConfigurationTest {
    @Bean
    public RepositoryCalculatedArea repository() {
        System.out.println("### Created RepositoryCalculatedArea mock");
        RepositoryCalculatedArea rca = mock(RepositoryCalculatedArea.class);
        when(rca.count()).thenReturn(-1L);
        return rca;
    }

    @Bean
    public HelloService helloService() {
        System.out.println("### Created HelloService mock");
        HelloService ret = mock(HelloService.class);
        when(ret.getHello()).thenReturn("Mocked World!");
        return ret;
    }
}
