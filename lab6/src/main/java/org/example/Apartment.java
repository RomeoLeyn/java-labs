package org.example;


public class Apartment {
    private static transient int SID = 1;
    private final int id;
    private final int number;
    private final int area;
    private final int floor;
    private final int countRoom;
    private final String street;

    public Apartment(int number, int area, int floor, int countRoom, String street) {
        this.id = setID();
        this.number = number;
        this.area = area;
        this.floor = floor;
        this.countRoom = countRoom;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public int getArea() {
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
                "id = " + id + '\n' +
                "number = " + number + '\n' +
                "area = " + area + '\n' +
                "floor = " + floor + '\n' +
                "countRoom = " + countRoom + '\n' +
                "street = " + street + '\'' + '\n';
    }

    private int setID() {
        return SID++;
    }
}