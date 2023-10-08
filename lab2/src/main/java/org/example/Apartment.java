package org.example;
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


    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", number=" + number +
                ", area=" + area +
                ", floor=" + floor +
                ", countRoom=" + countRoom +
                ", street='" + street + '\'' +
                '}';
    }
}
