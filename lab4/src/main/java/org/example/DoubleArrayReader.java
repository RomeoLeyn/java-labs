package org.example;

import java.io.File;
public interface DoubleArrayReader {
    double[] readOneDimensionalArray(String path);
    double[] readOneDimensionalArray(File file);

    double[][] readTwoDimensionalArray(String path);
    double[][] readTwoDimensionalArray(File file);
}