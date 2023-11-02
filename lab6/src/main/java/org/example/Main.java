package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ApartmentList apartmentList = new ApartmentList();

        Apartment apartment1 = new Apartment(101, 50, 3, 2, "Street");
        Apartment apartment2 = new Apartment(202, 80, 8, 6, "Street");
        Apartment apartment3 = new Apartment(303, 90, 5, 4, "Street");
        Apartment apartment4 = new Apartment(404, 65, 2, 4, "Street");
        Apartment apartment5 = new Apartment(505, 35, 4, 3, "Street");

        apartmentList.addApartment(apartment1);
        apartmentList.addApartment(apartment2);
        apartmentList.addApartment(apartment3);
        apartmentList.addApartment(apartment4);
        apartmentList.addApartment(apartment5);

        String path = "text.txt";
        String pathDat = "dat.dat";

        FileHandler fileHandler = new FileHandler(path);
        BinaryFileHandler binaryFileHandler = new BinaryFileHandler(pathDat);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            int choice = Menu.showMenu();

            switch (choice) {
                case 1:

                    System.out.print("Enter number = ");
                    int number = scanner.nextInt();

                    System.out.print("Enter area = ");
                    int region = scanner.nextInt();

                    System.out.print("Enter floor = ");
                    int storey = scanner.nextInt();

                    System.out.print("Enter count room = ");
                    int room = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter street = ");
                    String street = scanner.nextLine();

                    Apartment apartment = new Apartment(number, region, storey, room, street);

                    apartmentList.addApartment(apartment);


                    break;

                case 2:

                    apartmentList.showAllInfo();

                    break;

                case 3:

                    System.out.print("Enter the number to search = ");
                    System.out.println(apartmentList.searchApartmentByNumber(scanner.nextInt()));

                    break;

                case 4:

                    System.out.print("Enter count room = ");
                    System.out.println(apartmentList.filterByCountRoom(scanner.nextInt()));

                    break;

                case 5:

                    System.out.print("Enter count room = ");
                    int floor = scanner.nextInt();

                    System.out.print("Enter count min floor = ");
                    int minCountRoom = scanner.nextInt();

                    System.out.print("Enter count max floor = ");
                    int maxCountRoom = scanner.nextInt();

                    System.out.println(apartmentList.filterByCountRoomAndFloor(floor, minCountRoom, maxCountRoom));

                    break;

                case 6:

                    System.out.print("Enter area = ");
                    System.out.println(apartmentList.filterByAboveArea(scanner.nextInt()));

                    break;

                case 7:
                    fileHandler.fileWriter(apartmentList);
                    break;

                case 8:
                    StringBuilder fileText = fileHandler.fileReader();
                    System.out.println(fileText);
                    break;

                case 9:
                    binaryFileHandler.binaryFileWriter(apartmentList);
                    break;

                case 10:
                    StringBuilder fileBinary = binaryFileHandler.binaryFileReader();
                    System.out.println(fileBinary);
                    break;

                case 11:
                    System.out.print("Enter number apartment = ");
                    apartmentList.removeApartment(scanner.nextInt());
                    break;

                case 0:

                    exit = true;
                    scanner.close();
                    break;

                default:
                    System.err.println("Error data");
                    break;
            }
        }
    }
}