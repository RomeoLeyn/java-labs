package org.example;

import java.io.Serializable;

public class Apartment implements Serializable, Comparable<Apartment> {
    private static long SID = 1;
    private transient long ID = 0;
    private  int number;
    private  double area;
    private  int floor;
    private  int countRoom;
    private  String street;

    public Apartment() {

    }

    public Apartment(int number, double area, int floor, int countRoom, String street) {
        this.ID = setID();
        this.number = number;
        this.area = area;
        this.floor = floor;
        this.countRoom = countRoom;
        this.street = street;
    }

    public long getID() {
        return ID;
    }

    public int getNumber() {
        return number;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public int getCountRoom() {
        return countRoom;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return '\n' +
                "id = " + ID + '\n' +
                "number = " + number + '\n' +
                "area = " + area + '\n' +
                "floor = " + floor + '\n' +
                "countRoom = " + countRoom + '\n' +
                "street = " + street + '\n';
    }

    private long setID() {
        return SID++;
    }

    @Override
    public int compareTo(Apartment o) {
        return Long.compare(this.ID, o.getID());
    }
}