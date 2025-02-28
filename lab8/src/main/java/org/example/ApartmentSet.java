package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApartmentSet {

    private SortedSet<Apartment> apartmentSet;

    ApartmentSet() {
        apartmentSet = new TreeSet<>();
    }

    ApartmentSet(SortedSet<Apartment> apartmentSet) {
        this.apartmentSet = apartmentSet;
    }

    public void addApartment(Apartment apartment) {
        apartmentSet.add(apartment);
    }

    public void print() {
        for (Apartment a : apartmentSet) {
            System.out.println(a);
        }
    }

    public SortedSet<Apartment> sortByCountRoom(int room) {
       return apartmentSet.stream()
               .filter(apartment -> apartment.getCountRoom() >= room)
               .collect(Collectors.toCollection(TreeSet::new));
    }

    public SortedSet<Apartment> sortByCountRoomAndFloorInterval(int room, int minFloor, int maxFloor) {

        Comparator<Apartment> comparator = Comparator
                .comparingInt(Apartment::getCountRoom)
                .thenComparing(Apartment::getFloor);

        return apartmentSet.stream()
                .filter(apartment -> apartment.getCountRoom() >= room &&
                        apartment.getFloor() >= minFloor && apartment.getFloor() <= maxFloor)
                .sorted(comparator)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public SortedSet<Apartment> sortByAboveArea(int area) {
       return apartmentSet.stream()
               .filter(apartment -> apartment.getArea()>=area)
               .collect(Collectors.toCollection(TreeSet::new));
    }

    public SortedSet<Apartment> sortByAreaAscending() {
        Comparator<Apartment> comparator = Comparator.comparingDouble(Apartment::getArea);
        return apartmentSet.stream()
                .sorted(comparator).
                collect(Collectors.toCollection(TreeSet::new));
    }

    SortedSet<Integer> getFloorsWithApartmentsDescendingOrder() {

        return apartmentSet.stream()
                .map(apartment -> apartment.getFloor())
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public SortedSet<Apartment> sortApartmentsByFloor(int floor) {
        return apartmentSet.stream()
                .filter(apartment -> apartment.getFloor() == floor)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public String toString() {
        return "\t ApartmentSet" + apartmentSet;
    }
}