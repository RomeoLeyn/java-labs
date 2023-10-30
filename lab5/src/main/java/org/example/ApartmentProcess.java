package org.example;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApartmentProcess implements Serializable {

    private Apartment[] apartments;

    public ApartmentProcess(Apartment[] apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "{ " + Arrays.toString(apartments) + '}' + "\n";
    }

    public void addApartment(Apartment element) {
        if (isFullArray()) {
            expandArray();
        }
        apartments[apartments.length - 1] = element;
    }

    public void showAllInfoOfApartments() {
        if (isEmpty()) {
            System.out.println(Arrays.toString(apartments));
        } else {
            System.out.println("No information, please fill it out");
        }
    }

    public Apartment[] filterApartmentsByRoomCount(int countRoom) {
        List<Apartment> list = new ArrayList<>();

        for (Apartment apartment : this.apartments) {
            if (apartment.getCountRoom() == countRoom) {
                list.add(apartment);
            }
        }
        return list.toArray(new Apartment[list.size()]);
    }

    public Apartment[] filterApartmentsByRoomAndFloorRange(int countRoom, int minFloor, int maxFloor) {
        List<Apartment> list = new ArrayList<>();

        for (Apartment apartment : this.apartments) {
            if (apartment.getCountRoom() == countRoom && apartment.getFloor() >= minFloor && apartment.getFloor() <= maxFloor) {
                list.add(apartment);
            }
        }
        return list.toArray(new Apartment[list.size()]);
    }

    public Apartment[] showApartmentsWithAreaAbove(int area) {
        List<Apartment> list = new ArrayList<>();

        for (Apartment apartment : this.apartments) {
            if (apartment.getArea() >= area) {
                list.add(apartment);
            }
        }

        return list.toArray(new Apartment[list.size()]);
    }

    public void removeApartmentByNumber(int number) {
        if (isIDInArray(number)) {
            for (int i = 0; i < apartments.length; i++) {
                if (apartments[i].getNumber() == number) {
                    apartments[i] = null;
                    reduceArray();
                }
            }
        } else {
            System.out.println("Number apartment not found");
        }
    }

    private boolean isFullArray() {
        for (Apartment apartment : apartments) {
            if (apartment == null) {
                return false;
            }
        }
        return true;
    }

    private void expandArray() {
        apartments = Arrays.copyOf(apartments, apartments.length + 1);
    }

    private boolean isEmpty() {
        boolean isFull = true;
        for (Apartment apartment : apartments) {
            if (apartment == null) {
                isFull = false;
            }
        }
        return isFull;
    }

    private boolean isIDInArray(int number) {
        for (Apartment apartment : apartments) {
            if (apartment.getNumber() == number) {
                return true;
            }
        }
        return false;
    }

    private void reduceArray() {
        Apartment[] newApartmentArray = new Apartment[apartments.length - 1];

        for (int i = 0; i < apartments.length; i++) {
            if (!(apartments[i] == null)) {
                newApartmentArray[i] = apartments[i];
            }
        }

        apartments = newApartmentArray;
    }
}