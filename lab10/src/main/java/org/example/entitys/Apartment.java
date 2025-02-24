package org.example.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "apartments")
@Setter
@Getter
@ToString
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number")
    private int number;

    @Column(name = "area")
    private int area;

    @Column(name = "floor")
    private int floor;

    @Column(name = "countroom")
    private int countRoom;

    @Column(name = "street")
    private String street;


    public Apartment() {
    }

    public Apartment(int number, int area, int floor, int countRoom, String street) {
        this.number = number;
        this.area = area;
        this.floor = floor;
        this.countRoom = countRoom;
        this.street = street;
    }
}