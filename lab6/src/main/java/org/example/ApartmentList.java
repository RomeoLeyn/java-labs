package org.example;

import java.util.ArrayList;
import java.util.List;

public class ApartmentList {
    private List<Apartment> apartments;

    public ApartmentList() {
        this.apartments = new ArrayList<>();
    }

    public ApartmentList(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public void removeApartment(int number) {
        apartments.remove(searchIndex(number));
    }

    @Override
    public String toString() {
        return "apartments \n" + apartments;
    }

    public void showAllInfo() {
        System.out.println(apartments);
    }

    public ApartmentList searchApartmentByNumber(int number) {
        ApartmentList apartment = new ApartmentList();
        if (apartments.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Apartment ap : apartments) {
                if (ap.getNumber() == number) {
                    apartment.addApartment(ap);
                }
            }
        }
        return apartment;
    }

    public ApartmentList filterByCountRoom(int countRoom) {
        ApartmentList apartment = new ApartmentList();
        if (apartments.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Apartment ap : apartments) {
                if (ap.getCountRoom() == countRoom) {
                    apartment.addApartment(ap);
                }
            }
        }
        return apartment;
    }

    public ApartmentList filterByCountRoomAndFloor(int countRoom, int minFloor, int maxFloor) {
        ApartmentList apartment = new ApartmentList();
        if (apartments.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Apartment ap : apartments) {
                if (ap.getCountRoom() == countRoom && ap.getFloor() >= minFloor && ap.getFloor() <= maxFloor) {
                    apartment.addApartment(ap);
                }
            }
        }
        return apartment;
    }

    public ApartmentList filterByAboveArea(int area) {
        ApartmentList apartment = new ApartmentList();
        if (apartments.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Apartment ap : apartments) {
                if (ap.getArea() >= area) {
                    apartment.addApartment(ap);
                }
            }
        }
        return apartment;
    }


    private int searchIndex(int number) {
        int indexToRemove = 0;

        for (int i = 0; i < apartments.size(); i++) {
            Apartment apartment = apartments.get(i);
            if (apartment.getNumber() == number) {
                indexToRemove = i;
            }
        }

        return indexToRemove;
    }
}