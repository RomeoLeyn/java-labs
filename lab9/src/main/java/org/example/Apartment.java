package org.example;

public class Apartment {
    private int id;
    private int number;
    private int area;
    private int floor;
    private int countRoom;
    private String street;

    public Apartment() {

    }

    public Apartment( int number, int area, int floor, int countRoom, String street) {
//        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setCountRoom(int countRoom) {
        this.countRoom = countRoom;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "\t Apartment" + '\n' +
                "id=" + id + '\n' +
                "number=" + number + '\n' +
                "area=" + area + '\n' +
                "floor=" + floor + '\n' +
                "countRoom=" + countRoom + '\n' +
                "street='" + street + '\'' + '\n';
    }
}
