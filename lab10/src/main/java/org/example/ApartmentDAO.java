package org.example;

import jakarta.persistence.*;
import org.example.entitys.Apartment;

import java.util.List;
import java.util.NoSuchElementException;

public class ApartmentDAO {

    private EntityManagerFactory entityManagerFactory;

    public ApartmentDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    void insert(Apartment apartment) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            entityManager.getTransaction().begin();
            entityManager.persist(apartment);
            entityManager.getTransaction().commit();

        } catch (IllegalArgumentException exception) {
            throw exception;
        } catch (IllegalStateException | EntityExistsException | RollbackException exception) {
            System.err.println(exception.getMessage());
        }
    }


    List<Apartment> select() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("FROM Apartment", Apartment.class).getResultList();
        } catch (IllegalArgumentException exception) {
            throw exception;
        }
    }


    Apartment findById(long id) {
        Apartment apartment = null;

        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            apartment = entityManager.find(Apartment.class, id);

        } catch (IllegalArgumentException exception) {
            throw exception;
        }
        return apartment;
    }

    void update(Apartment apartment) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            entityManager.getTransaction().begin();
            Apartment apartmentToFind = findById(apartment.getId());

            if (apartmentToFind != null) {

                apartmentToFind.setNumber(apartment.getNumber());
                apartmentToFind.setArea(apartment.getArea());
                apartmentToFind.setFloor(apartment.getFloor());
                apartmentToFind.setCountRoom(apartment.getCountRoom());
                apartmentToFind.setStreet(apartment.getStreet());
                entityManager.merge(apartmentToFind);

            } else {
                throw new NoSuchElementException("Not found");
            }
            entityManager.getTransaction().commit();
        } catch (IllegalStateException | RollbackException exception) {
            System.err.println(exception.getMessage());
        }
    }


    void removeByID(long ID) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            entityManager.getTransaction().begin();
            Apartment apartmentToDelete = entityManager.find(Apartment.class, ID);
            entityManager.remove(apartmentToDelete);
            entityManager.getTransaction().commit();

        } catch (IllegalArgumentException | TransactionRequiredException exception) {
            throw exception;
        }
    }

    List<Apartment> listApartmentByCountRoom(int room) {

        List<Apartment> apartmentList;

        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            Query query = entityManager.createQuery("SELECT a FROM Apartment  a WHERE a.countRoom =:countRoom", Apartment.class);
            query.setParameter("countRoom", room);
            apartmentList = query.getResultList();

        } catch (IllegalArgumentException exception) {
            throw exception;
        }
        return apartmentList;
    }


    List<Apartment> listByCountRoomAndFloorInterval(int countRoom, int minFloor, int maxFloor) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            Query query = entityManager.createQuery("SELECT a FROM Apartment a WHERE a.countRoom = :countroom " +
                    "AND a.floor BETWEEN :min_floor AND :max_floor", Apartment.class);
            query.setParameter("countroom", countRoom);
            query.setParameter("min_floor", minFloor);
            query.setParameter("max_floor", maxFloor);

            return query.getResultList();

        } catch (IllegalArgumentException exception) {
            throw exception;
        }
    }

    List<Apartment> listApartmentAboveArea(int area) {
        List<Apartment> apartmentList;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            Query query = entityManager.createQuery("SELECT a FROM Apartment a WHERE a.area >= :area");
            query.setParameter("area", area);
            apartmentList = query.getResultList();

        } catch (IllegalArgumentException exception) {
            throw exception;
        }
        return apartmentList;
    }
}