package com.mooo.bitarus;

import java.util.Scanner;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.mooo.bitarus.Shape.ShapeType;

@Component
public class Runner implements CommandLineRunner {

    private Scanner scanner;
    private double lastCalculatedArea;
    private RepositoryCalculatedArea repository;
    @Value("${spring.profiles.active}")
    private String activeProfile;
    private HelloService helloService;

    public Runner(RepositoryCalculatedArea repository, HelloService helloService) {
        this.scanner = new Scanner(System.in);
        this.repository = repository;
        this.helloService = helloService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Profile " + this.activeProfile);
        System.out.println("HelloService " + this.helloService.getHello());
        Shape.ShapeType shapeType = getShapeToCalculate();
        Shape shape = Shape.createShape(shapeType, this.scanner);
        this.lastCalculatedArea = shape.calculateArea();

        EntityCalculatedArea ca = new EntityCalculatedArea();
        ca.setArea(shape.calculateArea());
        ca.setShapeType(shape.getClass().getSimpleName());
        this.repository.save(ca);
        this.repository.flush();
        System.out.println(String.format("Area %s %f count %d", shape.getClass().getSimpleName(),
                this.lastCalculatedArea, this.repository.count()));
    }

    private Shape.ShapeType getShapeToCalculate() {
        int ret = -1;
        Shape.ShapeType shapeType = null;
        boolean intObtained = false;

        while (intObtained == false) {
            System.out.println("Calcute area to which figure type?");
            System.out.println(" 1) Triangule");
            System.out.println(" 2) Circle ");
            System.out.println(" 3) Rectangule ");
            System.out.print("> ");

            String shape = "";
            shape = scanner.nextLine();

            try {
                ret = Integer.parseInt(shape);
                if (ret < 1 || ret > 3) {
                    intObtained = false;
                } else {
                    intObtained = true;
                    shapeType = ShapeType.values()[ret - 1];
                }
            } catch (Exception ex) {
                intObtained = false;
            }
        }

        return shapeType;
    }

    public double getLastCalculatedArea() {
        return lastCalculatedArea;
    }

    @PreDestroy
    public void preDestroy() {
        this.scanner.close();
    }
}
