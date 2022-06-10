package com.mooo.bitarus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@Profile("test")
@SpringBootTest(classes = ConfigurationTest.class)
public class TestHelloService {
    @Autowired
    HelloService helloService;

    @Test
    public void testHelloService() {
        assertEquals("Mocked World!", helloService.getHello());
    }
}
