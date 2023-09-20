package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Apartment[] apartment = new Apartment[5];
        Scanner scanner = new Scanner(System.in);

        apartment[0] = new Apartment(1, 101, 80, 3, 2, "вул. Перша");
        apartment[1] = new Apartment(2, 202, 60, 5, 1, "вул. Друга");
        apartment[2] = new Apartment(3, 303, 120, 2, 3, "вул. Третя");
        apartment[3] = new Apartment(4, 404, 95, 4, 2, "вул. Четверта");
        apartment[4] = new Apartment(5, 505, 70, 1, 2, "вул. П'ята");

        boolean exit = false;

        while (!exit) {

            System.out.println("1 - Count room");
            System.out.println("2 - Count room and floor");
            System.out.println("3 - Area");
            System.out.println("4 - Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter count room = ");

                    int countRoom = scanner.nextInt();

                    for (int i = 0; i < apartment.length; i++) {
                        apartment[i].printCountRoom(countRoom);
                    }
                    break;
                case 2:
                    System.out.print("Enter floor = ");
                    int floor = scanner.nextInt();

                    System.out.print("Enter count room = ");
                    countRoom = scanner.nextInt();

                    for (int i = 0; i < apartment.length; i++) {
                        apartment[i].printCountRoomAndFloor(floor);
                        apartment[i].printCountRoom(countRoom);
                    }
                    break;
                case 3:
                    System.out.print("Enter area = ");
                    int area = scanner.nextInt();

                    for (int i = 0; i < apartment.length; i++) {
                        apartment[i].printArea(area);
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.err.println("Error data");
                    break;
            }
        }
    }
}