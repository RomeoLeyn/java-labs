package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        // File path
        String firstPath = "D:\\java-lab\\lab4\\lab4.txt";
        String secondPath = "D:\\java-lab\\lab4\\doubleArr.txt";

        // Creat of class objects
        FileRead fileReader = new FileRead();
        MinValueFinder findMin = new MinValueFinder();

        // Reading a one-dimensional array from a file
        double[] oneDimensionalArray = fileReader.readOneDimensionalArray(firstPath);

        // Show one-dimensional array
        findMin.processArray(oneDimensionalArray);

        // Reading a one-dimensional array from a file
        oneDimensionalArray = fileReader.readOneDimensionalArray(new File(firstPath));

        // Show one-dimensional array
        findMin.processArray(oneDimensionalArray);

        // Find the minimum value in a one-dimensional array
        double minValueIn1DArray = findMin.calculate(oneDimensionalArray);
        System.out.println("Min = " + minValueIn1DArray + "\n");

        // Reading a one-dimensional array from a file
        double[][] twoDimensionalArray = fileReader.readTwoDimensionalArray(secondPath);

        // Show two-dimensional array
        findMin.processArray(twoDimensionalArray);

        // Reading a two-dimensional array from a file
        twoDimensionalArray = fileReader.readTwoDimensionalArray(new File(secondPath));

        // Show two-dimensional array
        findMin.processArray(twoDimensionalArray);


        // Find min value in array two-dimensional array
        double minIn2DArray = findMin.calculate(twoDimensionalArray);
        System.out.println("Min in 2D array = " + minIn2DArray + "\n");

        // Finding the minimum value in the shaded area two-dimensional array
        double minValueIn2DArray2 = findMin.findMinValueInTheShadedArea(twoDimensionalArray);
        System.out.println("Min in the shaded area = " + minValueIn2DArray2);
    }
}