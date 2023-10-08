package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private Apartment[] apartments;

    public static void main(String[] args) {

        Main obj = new Main();
        obj.showMenu();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("1 - Fill array");
            System.out.println("2 - Show all info");
            System.out.println("3 - Filter by count room");
            System.out.println("4 - Filter by count room and floor");
            System.out.println("5 - Show with above area");
            System.out.println("6 - Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter size array");

                    int size = scanner.nextInt();
                    createAndFillObjectArray(size);

                    break;

                case 2:
                    showAllInfoOfApartments();
                    break;

                case 3:
                    System.out.print("Enter count room = ");
                    int countRoom = scanner.nextInt();

                    filterApartmentsByRoomCount(countRoom);

                    break;

                case 4:

                    System.out.print("Enter floor = ");
                    int floor = scanner.nextInt();

                    System.out.print("Enter count min room = ");
                    int minCountRoom = scanner.nextInt();

                    System.out.print("Enter count max room = ");
                    int maxCountRoom = scanner.nextInt();

                    filterApartmentsByRoomAndFloorRange(floor, minCountRoom, maxCountRoom);

                    break;

                case 5:

                    System.out.print("Enter area = ");
                    int area = scanner.nextInt();

                    showApartmentsWithAreaAbove(area);

                    break;

                case 6:

                    exit = true;
                    scanner.close();
                    break;

                default:
                    System.err.println("Error data");
                    break;
            }
        }
    }

    public void createAndFillObjectArray(int size) {

        int id = 1;
        Scanner scanner = new Scanner(System.in);

        apartments = new Apartment[size];

        for (int i = 0; i < apartments.length; i++) {

            System.out.println("Number");
            int number = scanner.nextInt();

            System.out.println("area");
            int area = scanner.nextInt();

            System.out.println("floor");
            int floor = scanner.nextInt();

            System.out.println("count room");
            int countRoom = scanner.nextInt();
            scanner.nextLine();

            System.out.println("street");
            String street = scanner.nextLine();

            apartments[i] = new Apartment(id, number, area, floor, countRoom, street);

            id++;
        }
    }

    public void showAllInfoOfApartments() {
        if (apartments == null) {
            System.out.println("No information, please fill it out");
        } else {
            System.out.println(Arrays.toString(apartments));
        }
    }

    public void filterApartmentsByRoomCount(int countRoom) {
        for (Apartment value : apartments) {
            if (value.getCountRoom() == countRoom) {
                System.out.println(value);
            }
        }
    }

    public void filterApartmentsByRoomAndFloorRange(int countFloor, int minCountRoom, int maxCountRoom) {
        for (Apartment apartment : apartments) {
            if (apartment.getFloor() == countFloor && apartment.getCountRoom() >= minCountRoom && apartment.getCountRoom() <= maxCountRoom) {
                System.out.println(apartment);
            }
        }
    }

    public void showApartmentsWithAreaAbove(int area) {
        for (Apartment apartment : apartments) {
            if (apartment.getArea() >= area) {
                System.out.println(apartment);
            }
        }
    }
}