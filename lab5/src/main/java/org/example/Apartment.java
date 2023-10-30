package org.example;

import java.io.Serializable;

public class Apartment implements Serializable {
    private static int nextID = 1;

    private int id;
    private int number;
    private int area;
    private int floor;
    private int countRoom;
    private String street;


    public Apartment(int number, int area, int floor, int countRoom, String street) {
        this.id = nextID();
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
        return '\n' +  " Apartment " + '\n' +
                "id = " + id + '\n' +
                "number = " + number + '\n' +
                "area = " + area + '\n' +
                "floor = " + floor + '\n' +
                "countRoom = " + countRoom + '\n' +
                "street = " + street + '\n';
    }

    private int nextID() {
        return this.nextID++;
    }
}