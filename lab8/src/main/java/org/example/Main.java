package org.example;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

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


        System.out.println("\n\t A list of apartments that have a given number of rooms");
        SortedSet<Apartment> sortedApartmentByCountRoom = apartmentSet.sortByCountRoom(3);
        System.out.println(sortedApartmentByCountRoom);

        System.out.println("\n\t A list of apartments that have a given number of rooms and are located on\n" +
                "floor, which is in the specified interval");
        SortedSet<Apartment> sortedApartmentByCountOfRoomsAndFloorInterval =
                apartmentSet.sortByCountRoomAndFloorInterval(3, 1, 6);
        System.out.println(sortedApartmentByCountOfRoomsAndFloorInterval);


        System.out.println("\n\t A list of apartments that have an area that exceeds the specified area");
        SortedSet<Apartment> sortedApartmentByAboveArea = apartmentSet.sortByAboveArea(50);
        System.out.println(sortedApartmentByAboveArea);

        System.out.println("\n\t \n A list of all apartments, in order of increasing area");
        SortedSet<Apartment> sortedByAreaAscending = apartmentSet.sortByAreaAscending();
        System.out.println(sortedByAreaAscending);

        System.out.println("\n\t\n List of floors on which apartments are located");
        SortedSet<Integer> sortedByFloor = apartmentSet.getFloorsWithApartmentsDescendingOrder();
        for (int a:sortedByFloor) {
            System.out.println(a);
        }

        System.out.println("\n\t\n Display a list of apartments for each floor");
        SortedSet<Apartment> sortedApartmentsByFloor = apartmentSet.sortApartmentsByFloor(3);
        System.out.println(sortedApartmentsByFloor);
    }
}