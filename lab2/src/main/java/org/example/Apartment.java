package org.example;

import java.io.PrintStream;

public class Apartment {
    private int id;
    private int number;
    private int area;
    private int floor;
    private int countRoom;
    private String street;

    public Apartment(int id, int number, int area, int floor, int countRoom, String street) {
        this.id = id;
        this.number = number;
        this.area = area;
        this.floor = floor;
        this.countRoom = countRoom;
        this.street = street;
    }

    public int getId() {
        return this.id;
    }

    public int getNumber() {
        return this.number;
    }

    public int getArea() {
        return this.area;
    }

    public int getFloor() {
        return this.floor;
    }

    public int getCountRoom() {
        return this.countRoom;
    }

    public String getStreet() {
        return this.street;
    }

    public void printCountRoom(int room) {
        if (this.countRoom == room) {
            PrintStream var10000 = System.out;
            int var10001 = this.getId();
            var10000.println("id = " + var10001 + "\nNumber = " + this.getNumber() + "\nArea = " + this.getArea() + "\nFloor = " + this.getFloor() + "\nCount room = " + this.getCountRoom() + "\nStreet = " + this.getStreet());
        } else {
            System.out.println("Nothing found");
        }

    }

    public void printCountRoomAndFloor(int floor) {
        if (this.floor == floor) {
            PrintStream var10000 = System.out;
            int var10001 = this.getId();
            var10000.println("id = " + var10001 + "\nNumber = " + this.getNumber() + "\nArea = " + this.getArea() + "\nFloor = " + this.getFloor() + "\nCount room = " + this.getCountRoom() + "\nStreet = " + this.getStreet());
        } else {
            System.out.println("Nothing found");
        }

    }

    public void printArea(int area) {
        if (this.area > area) {
            PrintStream var10000 = System.out;
            int var10001 = this.getId();
            var10000.println("id = " + var10001 + "\nNumber = " + this.getNumber() + "\nArea = " + this.getArea() + "\nFloor = " + this.getFloor() + "\nCount room = " + this.getCountRoom() + "\nStreet = " + this.getStreet());
        } else {
            System.out.println("Nothing found");
        }

    }
}
