package org.example;

import java.util.Scanner;

public class Menu {
    public static int showMenu() {
        System.out.println("1 - Search apartment by ID");
        System.out.println("2 - Delete apartment");
        System.out.println("3 - List of apartments with number of rooms");
        System.out.println("4 - List apartments that have a given number rooms and floor interval");
        System.out.println("5 - List apartments that have with area above");
        System.out.println("6 - List apartments in order of increasing area");
        System.out.println("7 - List of floors on which apartments are located");
        System.out.println("8 - List of apartments for each floor");
        System.out.println("9 - Print all apartment");
        System.out.println("10 - Add apartment");
        System.out.println("11 - Binary file write");
        System.out.println("12 - Binary file read");
        System.out.println("13 - File write");
        System.out.println("14 - File read");
        System.out.println("0 - Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
