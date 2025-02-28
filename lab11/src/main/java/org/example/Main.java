package org.example;

import org.example.entitys.Apartment;
import org.example.service.ApartmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class Main implements CommandLineRunner {
    private final ApartmentService apartmentService;

    public Main(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);

        while (exit) {
            int choice = Menu.showMenu();
            switch (choice) {

                case 1:

                    System.out.print("Enter number = ");
                    int number = scanner.nextInt();

                    System.out.println("Enter area");
                    int area = scanner.nextInt();

                    System.out.println("Enter floor");
                    int floor = scanner.nextInt();

                    System.out.println("Enter count room");
                    int countRoom = scanner.nextInt();

                    System.out.println("Enter street");
                    scanner.nextLine();
                    String street = scanner.nextLine();

                    Apartment apartment = new Apartment(number, area, floor, countRoom, street);

                    apartmentService.insertApartment(apartment);

                    break;

                case 2:
                    System.out.print("Enter count room = ");
                    List<Apartment> apartmentsByCountRoom = apartmentService.getApartmentByCountRoom(scanner.nextInt());
                    for (Apartment a: apartmentsByCountRoom) {
                        System.out.println(a);
                    }
                    break;

                case 3:

                    System.out.println("Enter count room and floor interval(min,max)");
                    int room = scanner.nextInt();
                    int minFloor = scanner.nextInt();
                    int maxFloor = scanner.nextInt();

                    List<Apartment> apartmentsByCountRoomAndFloorInterval = apartmentService.getApartmentByCountRoomAndFloorInterval(room, minFloor, maxFloor);
                    for (Apartment a : apartmentsByCountRoomAndFloorInterval) {
                        System.out.println(a);
                    }

                    break;

                case 4:
                    System.out.print("Enter with area above = ");
                    int withAreaAbove = scanner.nextInt();
                    List<Apartment> apartmentList = apartmentService.getApartmentWithAboveArea(withAreaAbove);
                    for (Apartment a: apartmentList) {
                        System.out.println(a);
                    }
                    break;

                case 5:
                    List<Apartment> allApartments = apartmentService.getAll();
                    for (Apartment a: allApartments) {
                        System.out.println(a);
                    }

                    break;

                case 6:
                    System.out.print("Enter id for delete = ");
                    apartmentService.deleteById(scanner.nextLong());
                    break;

                case 0:
                    exit = false;
                    scanner.close();
                    break;
            }
        }
    }
}