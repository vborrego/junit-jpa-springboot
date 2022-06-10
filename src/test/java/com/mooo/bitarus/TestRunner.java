package com.mooo.bitarus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class TestRunner {
    @Test
    public void testCalculateTriangleArea() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("1\n3\n2\n".getBytes()));
        Runner runner = new Runner(null, new HelloService());
        try {
            runner.run();
            runner.preDestroy();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assertEquals(3, runner.getLastCalculatedArea());
        System.setIn(stdin);
    }

    @Test
    public void testCalculateCircleArea() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("2\n3\n".getBytes()));
        Runner runner = new Runner(null, new HelloService());
        try {
            runner.run();
            runner.preDestroy();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assertEquals(28.274333882308138, runner.getLastCalculatedArea());
        System.setIn(stdin);
    }

    @Test
    public void testCalculateRectangleArea() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("3\n3\n5\n".getBytes()));
        Runner runner = new Runner(null, new HelloService());
        try {
            runner.run();
            runner.preDestroy();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assertEquals(15, runner.getLastCalculatedArea());
        System.setIn(stdin);
    }

    @Test
    public void testWrongMenuOption() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("100\n".getBytes()));
        Runner runner = new Runner(null, new HelloService());
        try {
            runner.run();
            runner.preDestroy();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assertEquals(0, runner.getLastCalculatedArea());
        System.setIn(stdin);
    }

    @Test
    public void testWrongMenuOptionNotNumber() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("aaa\n".getBytes()));
        Runner runner = new Runner(null, new HelloService());
        try {
            runner.run();
            runner.preDestroy();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assertEquals(0, runner.getLastCalculatedArea());
        System.setIn(stdin);
    }
}
