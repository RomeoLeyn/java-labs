package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Apartment apartment1 = new Apartment(101, 50, 5, 5, "str");
        Apartment apartment2 = new Apartment(202, 65, 6, 6, "str1");
        Apartment apartment3 = new Apartment(303, 55, 3, 3, "str2");
        Apartment apartment4 = new Apartment(404, 70, 3, 4, "str3");
        Apartment apartment5 = new Apartment(505, 58, 3, 3, "str4");

        SortedSet<Apartment> sortedSet = new TreeSet<>();

        sortedSet.add(apartment1);
        sortedSet.add(apartment2);
        sortedSet.add(apartment3);
        sortedSet.add(apartment4);
        sortedSet.add(apartment5);

        ApartmentSet apartmentSet = new ApartmentSet(sortedSet);
        BinaryFileHandler binaryFileHandler = new BinaryFileHandler("binary");
        FileHandler fileHandler = new FileHandler("textFile");

        Scanner scanner = new Scanner(System.in);

        boolean exit = true;

        while (exit) {
            int choice = Menu.showMenu();
            switch (choice) {

                case 1:

                    System.out.print("Enter ID = ");
                    Apartment apartmentFoundByID = apartmentSet.searchApartmentById(scanner.nextLong());
                    System.out.println("\t Apartment found \n" + apartmentFoundByID);
                    break;

                case 2:

                    System.out.print("Enter ID for delete = ");
                    if (apartmentSet.deleteApartmentById(scanner.nextLong())) {
                        System.out.println("Apartment delete");
                    }
                    break;

                case 3:

                    System.out.print("Enter number of rooms = ");
                    SortedSet<Apartment> sortedApartmentByCountRoom = apartmentSet.sortByCountRoom(scanner.nextInt());

                    for (Apartment a : sortedApartmentByCountRoom) {
                        System.out.println(a);
                    }

                    break;

                case 4:

                    System.out.print("Enter count room = ");
                    int room = scanner.nextInt();

                    System.out.print("Enter min floor = ");
                    int minFloor = scanner.nextInt();

                    System.out.print("Enter max floor = ");
                    int maxFloor = scanner.nextInt();

                    SortedSet<Apartment> sortedApartmentByCountOfRoomsAndFloorInterval = apartmentSet.sortByCountRoomAndFloorInterval(room, minFloor, maxFloor);
                    for (Apartment a : sortedApartmentByCountOfRoomsAndFloorInterval) {
                        System.out.println(a);
                    }

                    break;

                case 5:

                    System.out.print("Enter area = ");
                    SortedSet<Apartment> sortedApartmentByAboveArea = apartmentSet.sortByAboveArea(scanner.nextInt());
                    for (Apartment a : sortedApartmentByAboveArea) {
                        System.out.println(a);
                    }

                    break;

                case 6:

                    SortedSet<Apartment> sortedByAreaAscending = apartmentSet.sortByAreaAscending();
                    for (Apartment a : sortedByAreaAscending) {
                        System.out.println(a);
                    }

                    break;

                case 7:

                    SortedSet<Integer> sortedByFloor = apartmentSet.getFloorsWithApartmentsDescendingOrder();

                    System.out.println("\t List of floors on which apartments are located \n");

                    for (int a : sortedByFloor) {
                        System.out.println("Floor - " + a + '\n');
                    }

                    break;
                case 8:

                    System.out.print("Enter floor = ");
                    SortedSet<Apartment> sortedApartmentsByFloor = apartmentSet.sortApartmentsByFloor(scanner.nextInt());

                    for (Apartment a : sortedApartmentsByFloor) {
                        System.out.println(a);
                    }

                    break;
                case 9:
                    apartmentSet.print();
                    break;

                case 10:
                    System.out.println("Enter apartment number:");
                    int number = scanner.nextInt();

                    System.out.println("Enter apartment area:");
                    double area = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter apartment floor:");
                    int floor = scanner.nextInt();

                    System.out.println("Enter number of rooms in the apartment:");
                    int countRoom = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter street name:");
                    String street = scanner.nextLine();

                    Apartment apartment = new Apartment(number, area, floor, countRoom, street);
                    apartmentSet.addApartment(apartment);

                    break;

                case 11:
                    binaryFileHandler.binaryFileWriter(apartmentSet);
                    break;

                case 12:
                    StringBuilder stringBuilder = binaryFileHandler.binaryFileReader();
                    System.out.println(stringBuilder);
                    break;

                case 13:
                    fileHandler.fileWriter(apartmentSet);
                    break;

                case 14:
                    StringBuilder stringBuilder1 = fileHandler.fileReader();
                    System.out.println(stringBuilder1);
                    break;

                case 0:
                    exit = false;
                    break;

            }
        }
    }
}