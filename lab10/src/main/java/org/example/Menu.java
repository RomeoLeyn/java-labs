package org.example;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public static int showMenu() {
        System.out.println("1 - Insert");
        System.out.println("2 - Select");
        System.out.println("3 - Find apartment by id");
        System.out.println("4 - Update");
        System.out.println("5 - Remove by id");
        System.out.println("6 - List apartment by count room");
        System.out.println("7 - List by count room and interval floor");
        System.out.println("8 - List by above by area");
        System.out.println("0 - Exit");
        return scanner.nextInt();
    }
}
