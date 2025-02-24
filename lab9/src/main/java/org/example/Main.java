package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "12345678";

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                ApartmentDAO apartmentDAO = new ApartmentDAO(connection);
                Scanner scanner = new Scanner(System.in);

                boolean exit = true;


                while (exit) {
                    int choice = Menu.showMenu();
                    switch (choice) {
                        case 1:

                            List<Apartment> allApartments = apartmentDAO.select();
                            for (Apartment a : allApartments) {
                                System.out.println(a);
                            }


                            break;
                        case 2:

                            System.out.print("Enter the number of rooms = ");
                            List<Apartment> sortedApartmentsByCountRoom = apartmentDAO.filterByCountRoom(scanner.nextInt());
                            for (Apartment a : sortedApartmentsByCountRoom) {
                                System.out.println(a);
                            }

                            break;
                        case 3:

                            System.out.print("Enter count room = ");
                            int room = scanner.nextInt();

                            System.out.print("Enter min floor = ");
                            int minFloor = scanner.nextInt();

                            System.out.print("Enter max floor = ");
                            int maxFloor = scanner.nextInt();

                            List<Apartment> sortedApartmentsByNumberOfRoomsAndFloors = apartmentDAO.filterByCountRoomAndFloorInterval(room, minFloor, maxFloor);
                            for (Apartment a : sortedApartmentsByNumberOfRoomsAndFloors) {
                                System.out.println(a);
                            }

                            break;
                        case 4:

                            System.out.print("Enter the area that exceeds the given one = ");
                            List<Apartment> sortedApartmentsByArea = apartmentDAO.filterApartmentsWithAreaAbove(scanner.nextInt());
                            for (Apartment a: sortedApartmentsByArea) {
                                System.out.println(a);
                            }

                            break;

                        case 5:
                            System.out.print("Enter id = ");
                            Apartment apartmentFoundById = apartmentDAO.findById(scanner.nextInt());
                            System.out.println(apartmentFoundById);
                            break;

                        case 6:

                            System.out.print("Enter the apartment number = ");
                            int number = scanner.nextInt();

                            System.out.print("Enter the apartment area = ");
                            int area = scanner.nextInt();

                            System.out.print("Enter the apartment floor = ");
                            int floor = scanner.nextInt();

                            System.out.print("Enter the number of rooms in the apartment = ");
                            int countRoom = scanner.nextInt();

                            System.out.print("Enter the street name = ");
                            String street = scanner.next();

                            Apartment apartment = new Apartment(number, area, floor, countRoom, street);

                            int countInsertRows = apartmentDAO.insert(apartment);

                            if (countInsertRows == 1) {
                                System.out.println("Rows insert - " + countInsertRows + '\n');
                            } else {
                                System.err.println("Unable insert");
                            }


                            break;
                        case 7:

                            System.out.print("Enter the apartment number to delete = ");
                            int numberToDelete = scanner.nextInt();

                            System.out.print("Enter the apartment area to delete =");
                            int areaToDelete = scanner.nextInt();

                            System.out.print("Enter the apartment floor to delete = ");
                            int floorToDelete = scanner.nextInt();

                            System.out.print("Enter the number of rooms in the apartment to delete = ");
                            int countRoomToDelete = scanner.nextInt();

                            System.out.print("Enter the street name to delete = ");
                            String streetToDelete = scanner.next();

                            Apartment apartmentToDelete = new Apartment(numberToDelete, areaToDelete, floorToDelete, countRoomToDelete, streetToDelete);

                            int countDeleteRows = apartmentDAO.delete(apartmentToDelete);

                            if (countDeleteRows == 1) {
                                System.out.println("Rows delete - " + countDeleteRows + '\n');
                            } else {
                                System.err.println("Failed to delete data");
                            }

                            break;

                        case 8:
                            System.out.print("Enter the id to delete = ");

                            int countDeleteRowsById = apartmentDAO.deleteById(scanner.nextInt());

                            if (countDeleteRowsById == 1) {
                                System.out.println("Rows delete - " + countDeleteRowsById + '\n');
                            } else {
                                System.err.println("Failed to delete data");
                            }

                            break;

                        case 9:

                            System.out.print("Enter the apartment id which you want update = ");
                            int idToUpdate = scanner.nextInt();

                            System.out.print("Enter the apartment number for which you want to change the data = ");
                            int numberUpdate = scanner.nextInt();

                            System.out.print("Enter the new area for the apartment = ");
                            int areaUpdate = scanner.nextInt();

                            System.out.print("Enter the new floor for the apartment = ");
                            int floorUpdate = scanner.nextInt();

                            System.out.print("Enter the new number of rooms for the apartment = ");
                            int countRoomUpdate = scanner.nextInt();

                            System.out.print("Enter the new street name for the apartment = ");
                            String streetUpdate = scanner.next();

                            Apartment apartmentToUpdate = new Apartment(numberUpdate, areaUpdate, floorUpdate, countRoomUpdate, streetUpdate);
                            apartmentToUpdate.setId(idToUpdate);

                            int countRowsUpdate = apartmentDAO.update(apartmentToUpdate);

                            if (countRowsUpdate == 1) {
                                System.out.println("Rows update - " + countRowsUpdate + '\n');
                            } else {
                                System.err.println("Unable to update");
                            }

                            break;
                        case 0:
                            exit = false;
                            scanner.close();
                            break;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    }
}