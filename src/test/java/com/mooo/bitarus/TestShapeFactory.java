package com.mooo.bitarus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import com.mooo.bitarus.Shape.ShapeType;

public class TestShapeFactory {

    @Test
    public void testCreateCircle() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("3\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        Shape shape = Shape.createShape(ShapeType.Circle, scanner);
        assertEquals(Circle.class, shape.getClass());
        assertEquals(28.274333882308138, shape.calculateArea());
        System.setIn(stdin);
    }

    @Test
    public void testCreateRectangle() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("3\n4\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        Shape shape = Shape.createShape(ShapeType.Rectangle, scanner);
        assertEquals(Rectangle.class, shape.getClass());
        assertEquals(12, shape.calculateArea());
        System.setIn(stdin);
    }

    @Test
    public void testCreateTriangle() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("3\n5\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        Shape shape = Shape.createShape(ShapeType.Triangle, scanner);
        assertEquals(Triangle.class, shape.getClass());
        assertEquals(7.5, shape.calculateArea());
        System.setIn(stdin);
    }

    @Test
    public void testCreateTriangleWrongValue() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("3\n5a\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        try {
            Shape shape = Shape.createShape(ShapeType.Triangle, scanner);
        } catch (NoSuchElementException ex) {
            assertEquals(NoSuchElementException.class, ex.getClass());
        }

        System.setIn(stdin);
    }
}
