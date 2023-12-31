package org.example;
public interface ArrayProcessor {
    double calculate(double[] array);
    double calculate(double[][] array);

    void processArray(double[] array);
    void processArray(double[][] array);
    double findMinValueInTheShadedArea(double[][] array);
}