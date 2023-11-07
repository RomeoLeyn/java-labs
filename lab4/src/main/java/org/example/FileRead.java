package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class FileRead implements DoubleArrayReader {
    public double[] readOneDimensionalArray(String path) {

        try (Scanner scanner = new Scanner(new File(path))) {
            scanner.useLocale(Locale.US);
            int length = scanner.nextInt();

            double[] number = new double[length];

            for (int i = 0; i < number.length; i++) {
                number[i] = scanner.nextDouble();
            }

            return number;

        } catch (IOException e) {
            System.err.println();
            return null;
        }
    }

    @Override
    public double[] readOneDimensionalArray(File file) {
        try (Scanner scanner = new Scanner(file)) {

            scanner.useLocale(Locale.US);
            int length = scanner.nextInt();

            double[] number = new double[length];

            for (int i = 0; i < number.length; i++) {
                number[i] = scanner.nextDouble();
            }

            return number;

        } catch (IOException e) {
            System.err.println();
            return null;
        }

    }


    @Override
    public double[][] readTwoDimensionalArray(String path) {

        try (Scanner scanner = new Scanner(new File(path))) {
            scanner.useLocale(Locale.US);
            int length = scanner.nextInt();

            double[][] number = new double[length][length];

            for (int i = 0; i < number.length; i++) {
                for (int j = 0; j < number.length; j++) {
                    number[i][j] = scanner.nextDouble();
                }
            }
            return number;

        } catch (IOException e) {
            System.err.println();
            return null;
        }

    }

    @Override
    public double[][] readTwoDimensionalArray(File file) {
        try (Scanner scanner = new Scanner(file)) {

            scanner.useLocale(Locale.US);
            int length = scanner.nextInt();

            double[][] number = new double[length][length];

            for (int i = 0; i < number.length; i++) {
                for (int j = 0; j < number.length; j++) {
                    number[i][j] = scanner.nextDouble();
                }
            }

            return number;

        } catch (IOException e) {
            System.err.println();
            return null;
        }
    }
}
