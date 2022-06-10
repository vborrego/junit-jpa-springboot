package com.mooo.bitarus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@Profile("test")
@SpringBootTest(classes = ConfigurationTest.class)
public class TestApplication {

    private InputStream stdin;
    private PrintStream stdOut;
    private PrintStream stdErr;
    private ByteArrayOutputStream newStdOut;
    private ByteArrayOutputStream newStdErr;

    @BeforeEach
    public void setStdInStdOut() {
        this.stdin = System.in;
        this.stdOut = System.out;
        this.stdErr = System.err;
        this.newStdOut = new ByteArrayOutputStream();
        this.newStdErr = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newStdOut));
        System.setErr(new PrintStream(newStdErr));
    }

    @AfterEach
    public void setOriginalStdInStdOut() {
        System.setOut(this.stdOut);
        System.setErr(this.stdErr);
        System.setIn(this.stdin);
    }

    @Test
    public void testApplicationCalculateTriangleArea() {
        System.setIn(new ByteArrayInputStream("1\n3\n2\n".getBytes()));
        Application.main(new String[] { "" });
        assertEquals(true, this.newStdOut.toString().contains("Area Triangle 3.0"));        
    }

    @Test
    public void testApplicationCalculateCircleArea() {
        System.setIn(new ByteArrayInputStream("2\n3\n".getBytes()));
        Application.main(new String[] { "" });
        assertEquals(true, this.newStdOut.toString().contains("Area Circle 28.2743"));
    }

    @Test
    public void testApplicationCalculateRectangleArea() {
        System.setIn(new ByteArrayInputStream("3\n3\n5\n".getBytes()));
        Application.main(new String[] { "" });
        String out = this.newStdOut.toString();
        assertEquals(true, out.contains("Area Rectangle 15.0"));
    }
}
