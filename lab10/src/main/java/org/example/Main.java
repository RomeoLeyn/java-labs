package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entitys.Apartment;

import java.util.List;
import java.util.Scanner;


public class Main {

    public static EntityManagerFactory entityManagerFactory;
    public static final String unit = "org.hibernate.tutorial.jpa";

    public static void main(String[] args) {

        entityManagerFactory = getEntityManagerFactory();
        ApartmentDAO apartmentDAO = new ApartmentDAO(entityManagerFactory);


        boolean exit = true;
        Scanner scanner = new Scanner(System.in);

        while (exit) {
            int choice = Menu.showMenu();
            switch (choice) {

                case 1:

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

                    apartmentDAO.insert(apartment);
                    break;

                case 2:
                    List<Apartment> apartmentList = apartmentDAO.select();
                    for (Apartment a : apartmentList) {
                        System.out.println(a);
                    }
                    break;

                case 3:
                    System.out.print("Enter id = ");
                    Apartment byId = apartmentDAO.findById(scanner.nextLong());
                    System.out.println(byId);
                    break;

                case 4:
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

                    apartmentDAO.update(apartmentToUpdate);

                    break;

                case 5:
                    System.out.print("Enter id = ");
                    apartmentDAO.removeByID(scanner.nextLong());
                    break;

                case 6:
                    System.out.print("Enter count room = ");
                    List<Apartment> apartmentByCountRoom = apartmentDAO.listApartmentByCountRoom(scanner.nextInt());
                    for (Apartment a : apartmentByCountRoom) {
                        System.out.println(a);
                    }
                    break;

                case 7:
                    System.out.print("Enter count room = ");
                    int room = scanner.nextInt();

                    System.out.print("Enter min floor = ");
                    int minFloor = scanner.nextInt();

                    System.out.print("Enter max floor = ");
                    int maxFloor = scanner.nextInt();

                    List<Apartment> apartmentByCountRoomAndFloorInterval =
                            apartmentDAO.listByCountRoomAndFloorInterval(room, minFloor, maxFloor);

                    for (Apartment a : apartmentByCountRoomAndFloorInterval) {
                        System.out.println(a);
                    }

                    break;

                case 8:

                    System.out.print("Enter area = ");
                    List<Apartment> listByArea = apartmentDAO.listApartmentAboveArea(scanner.nextInt());

                    for (Apartment a : listByArea) {
                        System.out.println(a);
                    }

                    break;
                case 0:
                    exit = false;
                    scanner.close();
                    break;
            }
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory(unit);
    }
}