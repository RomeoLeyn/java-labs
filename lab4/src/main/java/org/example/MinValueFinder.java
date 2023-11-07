package org.example;

import java.util.Arrays;

public class MinValueFinder implements ArrayProcessor {

    @Override
    public double calculate(double[] array) {

        double temp = array[0];

        for (int i = 0; i < array.length; i++) {
            if (temp > array[i]) {
                temp = array[i];
            }
        }

        return temp;
    }

    @Override
    public double calculate(double[][] array) {

        double temp = array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (temp > array[i][j]) {
                    temp = array[i][j];
                }
            }
        }

        return temp;
    }

    @Override
    public void processArray(double[] array) {
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void processArray(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println();
    }

    @Override
    public double findMinValueInTheShadedArea(double[][] array) {
        double temp = array[0][0];

        for (int i = 0; i < array.length; i++) {

            int stars = (i < array.length / 2) ? i + 1 : array.length - i;

            for (int j = 0; j < array.length - stars; j++) {
                System.out.print("- ");
            }

            for (int j = 0; j < stars; j++) {
               System.out.print("* ");
                if (temp > array[i][j]) {
                    temp = array[i][j];
                }
            }
            System.out.println();
        }

        return temp;
    }
}