    package org.example;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public static int showMenu() {
        System.out.println("1 - Insert");
        System.out.println("2 - Get apartments by count room");
        System.out.println("3 - Select apartment by count room anf floor interval");
        System.out.println("4 - Select apartment with area above");
        System.out.println("5 - Get all apartments");
        System.out.println("6 - Delete by id");
        System.out.println("0 - Exit");
        return scanner.nextInt();
    }
}
