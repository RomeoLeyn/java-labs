package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculation {
    private double a = 16.5;
    private double b = 3.4;
    private double x = 0.61;
    private final double e = 2.71828182845904523536;

    public Calculation() {
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getX() {
        return x;
    }

    public double calculateS() {
        return Math.pow(this.x, 3) * Math.pow(Math.tan(1), 2) * Math.pow((this.x + this.b), 2) + this.a / Math.sqrt((this.x + this.b));
    }

    public double calculateQ() {
        return this.b * Math.pow(this.x, 2) - this.a / Math.pow(this.e, this.a + this.b) - 1;
    }

    public static void main(String[] args) {

        Calculation calculation = new Calculation();
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");


        String dateSimpleForm = simpleDateFormat.format(date);

        System.out.println("Вхідні дані:" + '\n' + "a = " + calculation.getA() + '\n' + "b = " + calculation.getB() +
                '\n' + "x = " + calculation.getX());

        System.out.println("Вирішення першого завдання = " + calculation.calculateS());
        System.out.println("Вирішення другого завдання = " + calculation.calculateQ());

        System.out.println("Поточна дата = " + dateSimpleForm);
    }
}