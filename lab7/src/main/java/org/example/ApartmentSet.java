package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

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
        SortedSet<Apartment> sortedApartmentByCountRoom = new TreeSet<>();

        for (Apartment a : this.apartmentSet) {
            if (a.getCountRoom() == room) {
                sortedApartmentByCountRoom.add(a);
            }
        }

        return sortedApartmentByCountRoom;
    }

    public SortedSet<Apartment> sortByCountRoomAndFloorInterval(int room, int minFloor, int maxFloor) {
        SortedSet<Apartment> sortedApartmentByRoomAndFloorInterval = new TreeSet<>();

        for (Apartment a : this.apartmentSet) {
            if (a.getCountRoom() == room && a.getFloor() >= minFloor && a.getFloor() <= maxFloor) {
                sortedApartmentByRoomAndFloorInterval.add(a);
            }
        }
        return sortedApartmentByRoomAndFloorInterval;
    }

    public SortedSet<Apartment> sortByAboveArea(int area) {
        SortedSet<Apartment> sortedByArea = new TreeSet<>();

        for (Apartment a : this.apartmentSet) {
            if (a.getArea() >= area) {
                sortedByArea.add(a);
            }
        }

        return sortedByArea;
    }

    public SortedSet<Apartment> sortByAreaAscending() {
        Comparator<Apartment> comparator = new Comparator<Apartment>() {
            @Override
            public int compare(Apartment o1, Apartment o2) {
                return Double.compare(o1.getArea(), o2.getArea());
            }
        };

        SortedSet<Apartment> sortedByAreaAscending = new TreeSet<>(comparator);
        sortedByAreaAscending.addAll(apartmentSet);

        return sortedByAreaAscending;
    }

    public SortedSet<Integer> getFloorsWithApartmentsDescendingOrder() {
        SortedSet<Integer> floors = new TreeSet<>(Collections.reverseOrder());
        for (Apartment a : apartmentSet) {
            floors.add(a.getFloor());
        }

        return floors;
    }

    public SortedSet<Apartment> sortApartmentsByFloor(int floor) {
        SortedSet<Apartment> sortedApartments = new TreeSet<>();

        for (Apartment a : this.apartmentSet) {
            if (a.getFloor() == floor) {
                sortedApartments.add(a);
            }
        }

        return sortedApartments;
    }

    public Apartment searchApartmentById(long id) {
        Apartment apartment = new Apartment();
        for (Apartment a : apartmentSet) {
            if (a.getID() == id) {
                apartment = a;
                break;
            }
        }
        return apartment;
    }

    public boolean deleteApartmentById(long ID) {
        boolean delete = false;

        if (apartmentContains(ID)) {
            apartmentSet.remove(getApartment(ID));
            delete = true;
        }
        return delete;
    }

    private boolean apartmentContains(long ID) {
        boolean apartmentIsExist = false;
        for (Apartment a : apartmentSet) {
            if (a.getID() == ID) {
                apartmentIsExist = true;
                break;
            }
        }
        return apartmentIsExist;
    }

    private Apartment getApartment(long ID) {
        Apartment apartmentFound = new Apartment();

        for (Apartment a : apartmentSet) {
            if (a.getID() == ID) {
                apartmentFound = a;
            }
        }
        return apartmentFound;
    }

    @Override
    public String toString() {
        return "\t ApartmentSet" + apartmentSet;
    }
}
