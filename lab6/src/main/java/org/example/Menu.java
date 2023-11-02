package org.example;

import java.util.Scanner;

public class Menu {
    public static int showMenu() {
        System.out.println("1 - Fill list");
        System.out.println("2 - Show all info");
        System.out.println("3 - Search apartment by number");
        System.out.println("4 - Filter by count room");
        System.out.println("5 - Filter by count room and floor");
        System.out.println("6 - Show with above area");
        System.out.println("7 - Write data to a file");
        System.out.println("8 - Read data from file");
        System.out.println("9 - Write data to a binary file");
        System.out.println("10 - Read data from binary file");
        System.out.println("11 - Delete by number apartment");
        System.out.println("0 - Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
