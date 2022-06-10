package com.mooo.bitarus;

public class Circle extends Shape {

    private double raio;

    public Circle(double raio) {
        this.raio = raio;
    }

    @Override
    public double calculateArea() {
        return Math.PI * this.raio * this.raio;
    }

}
