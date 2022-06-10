package com.mooo.bitarus;

import java.util.Scanner;

public abstract class Shape {
    public enum ShapeType {
        Triangle, Circle, Rectangle
    };

    public abstract double calculateArea();

    public static Shape createShape(ShapeType shapeType, Scanner scanner) {
        Shape shape = null;
        switch (shapeType) {
            case Triangle:
                shape = createTriangle(scanner);
                break;
            case Circle:
                shape = createCircle(scanner);
                break;
            case Rectangle:
                shape = createRectangule(scanner);
                break;
            default:
                break;
        }

        return shape;
    }

    public static Shape createTriangle(Scanner scanner) {
        System.out.println("Calculate triangle");
        double base = getValue("base", scanner);
        double height = getValue("height", scanner);
        return new Triangle(base, height);
    }

    public static Shape createCircle(Scanner scanner) {
        System.out.println("Calculate circle");
        double radius = getValue("radius", scanner);
        return new Circle(radius);
    }

    public static Shape createRectangule(Scanner scanner) {
        System.out.println("Calculate rectangle");
        double side1 = getValue("side 1", scanner);
        double side2 = getValue("side 2", scanner);
        return new Rectangle(side1, side2);
    }

    protected static double getValue(String prompt, Scanner scanner) {
        double ret = -1;
        boolean valueObtained = false;

        while (valueObtained == false) {
            System.out.print(prompt + "> ");

            String shape = "";
            shape = scanner.nextLine();

            try {
                ret = Double.parseDouble(shape);
                valueObtained = true;
            } catch (Exception ex) {
                valueObtained = false;
            }
        }

        return ret;
    }

}
