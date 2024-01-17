package org.example.service.impl;

import org.example.entitys.Apartment;
import org.example.repository.ApartmentRepository;
import org.example.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private ApartmentRepository apartmentRepository;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }


    @Override
    public void insertApartment(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

    @Override
    public List<Apartment> getApartmentByCountRoom(int countRoom) {
        return apartmentRepository.findByCountRoom(countRoom);
    }

    @Override
    public List<Apartment> getApartmentByCountRoomAndFloorInterval(int countRoom, int minFloor, int maxFloor) {
        return apartmentRepository.findApartmentByCountRoomAndFloorBetween(countRoom, minFloor, maxFloor);
    }

    @Override
    public List<Apartment> getApartmentWithAboveArea(int area) {
        return apartmentRepository.findApartmentByAreaGreaterThan(area);
    }

    @Override
    public List<Apartment> getAll() {
        return apartmentRepository.findAll();
    }

    public void deleteById(Long id) {
        apartmentRepository.deleteById(id);
    }
}
