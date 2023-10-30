package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String path = "text.txt";
        String pathDat = "dat.dat";

        Apartment[] apartments = new Apartment[5];


        apartments[0] = new Apartment(101, 80, 7, 3, "вул. Перша");
        apartments[1] = new Apartment(202, 60, 5, 3, "вул. Друга");
        apartments[2] = new Apartment(303, 120, 4, 6, "вул. Третя");
        apartments[3] = new Apartment(404, 95, 3, 4, "вул. Четверта");
        apartments[4] = new Apartment(505, 70, 1, 3, "вул. П'ята");

        ApartmentProcess apartmentProcess = new ApartmentProcess(apartments);
        FileHandler fileHandler = new FileHandler(path);
        BinaryFileHandler binaryFileHandler = new BinaryFileHandler(pathDat);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("1 - Fill array");
            System.out.println("2 - Show all info");
            System.out.println("3 - Filter by count room");
            System.out.println("4 - Filter by count room and floor");
            System.out.println("5 - Show with above area");
            System.out.println("6 - Write data to a file");
            System.out.println("7 - Read data from file");
            System.out.println("8 - Write data to a binary file");
            System.out.println("9 - Read data from binary file");
            System.out.println("10 - Delete by number apartment");
            System.out.println("0 - Exit");

            int choice = scanner.nextInt();
            Apartment[] arr;

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

                    apartmentProcess.addApartment(apartment);

                    break;

                case 2:
                    apartmentProcess.showAllInfoOfApartments();
                    break;

                case 3:
                    System.out.print("Enter count room = ");
                    int countRoom = scanner.nextInt();

                    arr = apartmentProcess.filterApartmentsByRoomCount(countRoom);
                    System.out.println(Arrays.toString(arr));
                    break;

                case 4:

                    System.out.print("Enter count room = ");
                    int floor = scanner.nextInt();

                    System.out.print("Enter count min floor = ");
                    int minCountRoom = scanner.nextInt();

                    System.out.print("Enter count max floor = ");
                    int maxCountRoom = scanner.nextInt();

                    arr = apartmentProcess.filterApartmentsByRoomAndFloorRange(floor, minCountRoom, maxCountRoom);

                    System.out.println(Arrays.toString(arr));

                    break;

                case 5:

                    System.out.print("Enter area = ");
                    int area = scanner.nextInt();

                    arr = apartmentProcess.showApartmentsWithAreaAbove(area);
                    System.out.println(Arrays.toString(arr));

                    break;

                case 6:

                    if (fileHandler.writeFile(apartmentProcess)) {
                        System.out.println("Data write in file ✔");
                    } else {
                        System.out.println("Error ❌");
                    }

                    break;

                case 7:
                    ApartmentProcess data = fileHandler.readFileByGson();
                    System.out.println(data);
                    break;

                case 8:
                    if (binaryFileHandler.BinaryFileWriter(apartmentProcess)) {
                        System.out.println("Data write in binary file ✔");
                    } else {
                        System.out.println("Error ❌");
                    }
                    break;

                case 9:
                    ApartmentProcess apartmentProcess1 = binaryFileHandler.BinaryFileReader();
                    System.out.println(apartmentProcess1);
                    break;

                case 10:
                    System.out.print("Enter apartment number = ");
                    int numberApartment = scanner.nextInt();
                    apartmentProcess.removeApartmentByNumber(numberApartment);
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