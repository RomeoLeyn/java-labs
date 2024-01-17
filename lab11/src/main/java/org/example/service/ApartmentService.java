package org.example.service;

import org.example.entitys.Apartment;

import java.util.List;

public interface ApartmentService {

    void insertApartment(Apartment apartment);

    List<Apartment> getApartmentByCountRoom(int countRoom);

    List<Apartment> getApartmentByCountRoomAndFloorInterval(int countRoom, int minFloor, int maxFloor);

    List<Apartment> getApartmentWithAboveArea(int area);

    List<Apartment> getAll();
    void deleteById(Long id);
}
