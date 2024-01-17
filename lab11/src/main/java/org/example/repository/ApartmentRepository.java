package org.example.repository;

import org.example.entitys.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findByCountRoom(int countRoom);
    List<Apartment> findApartmentByCountRoomAndFloorBetween(int countRoom, int minFloor, int maxFloor);
    List<Apartment> findApartmentByAreaGreaterThan(int area);
}