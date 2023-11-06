package org.example;

import java.util.Scanner;

public class Menu {
    public static int showMenu() {
        System.out.println("1 - Print all info");
        System.out.println("2 - Filter by count room");
        System.out.println("3 - Filter by count room and min/max floor");
        System.out.println("4 - Filter apartment by area");
        System.out.println("5 - Find by id");
        System.out.println("6 - Create apartment");
        System.out.println("7 - Delete apartment");
        System.out.println("8 - Delete apartment by id");
        System.out.println("9 - Update apartment");
        System.out.println("0 - Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
