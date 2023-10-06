package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Apartment[] apartmentArray = new Apartment[15];

        apartmentArray[0] = new Apartment(1, 101, 80, 3, 2, "вул. Перша");
        apartmentArray[1] = new Apartment(2, 202, 60, 5, 1, "вул. Друга");
        apartmentArray[2] = new Apartment(3, 303, 120, 2, 3, "вул. Третя");
        apartmentArray[3] = new Apartment(4, 404, 95, 4, 2, "вул. Четверта");
        apartmentArray[4] = new Apartment(5, 505, 70, 1, 2, "вул. П'ята");
        apartmentArray[5] = new Apartment(6, 606, 110, 2, 2, "вул. Шоста");
        apartmentArray[6] = new Apartment(7, 707, 85, 3, 1, "вул. Сьома");
        apartmentArray[7] = new Apartment(8, 808, 55, 1, 1, "вул. Восьма");
        apartmentArray[8] = new Apartment(9, 909, 75, 2, 2, "вул. Дев'ята");
        apartmentArray[9] = new Apartment(10, 1010, 100, 4, 2, "вул. Десята");
        apartmentArray[10] = new Apartment(11, 1111, 90, 3, 2, "вул. Одинадцята");
        apartmentArray[11] = new Apartment(12, 1212, 65, 2, 1, "вул. Дванадцята");
        apartmentArray[12] = new Apartment(13, 1313, 75, 2, 2, "вул. Тринадцята");
        apartmentArray[13] = new Apartment(14, 1414, 120, 3, 3, "вул. Чотирнадцята");
        apartmentArray[14] = new Apartment(15, 1515, 80, 2, 4, "вул. П'ятнадцята");

        menu(apartmentArray);
    }

    public static void menu(Apartment[] apartments) {
        Scanner scanner = new Scanner(System.in);
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

                    SearchByNumberOfRooms(countRoom, apartments);

                    break;
                case 2:

                    System.out.print("Enter floor = ");
                    int floor = scanner.nextInt();

                    System.out.print("Enter count min room = ");
                    int minCoutRoom = scanner.nextInt();

                    System.out.print("Enter count max room = ");
                    int maxCoutRoom = scanner.nextInt();

                    SearchByFloor(floor, minCoutRoom, maxCoutRoom, apartments);

                    break;
                case 3:

                    System.out.print("Enter area = ");
                    int area = scanner.nextInt();

                    SearchByArea(area, apartments);

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

    public static void SearchByNumberOfRooms(int countRoom, Apartment[] apartment) {
        for (Apartment value : apartment) {
            if (countRoom == value.getCountRoom()) {
                System.out.println(value);
            }
        }
    }

    public static void SearchByFloor(int countFloor, int minCountRoom, int maxCountRoom, Apartment[] apartments) {
        for (Apartment apartment : apartments) {
            if (apartment.getFloor() == countFloor && apartment.getCountRoom() >= minCountRoom && apartment.getCountRoom() <= maxCountRoom) {
                System.out.println(apartment);
            }
        }
    }

    public static void SearchByArea(int area, Apartment[] apartments) {
        for (Apartment apartment : apartments) {
            if (area >= apartment.getArea()) {
                System.out.println(apartment);
            }
        }
    }
}