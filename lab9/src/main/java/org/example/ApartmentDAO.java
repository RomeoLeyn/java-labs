package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDAO {

    private Connection connection;

    public ApartmentDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Apartment apartment) {

        String insertApartment = "INSERT INTO APARTMENT (number, area, floor, countRoom, street) VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertApartment)) {

            preparedStatement.setInt(1, apartment.getNumber());
            preparedStatement.setInt(2, apartment.getArea());
            preparedStatement.setInt(3, apartment.getFloor());
            preparedStatement.setInt(4, apartment.getCountRoom());
            preparedStatement.setString(5, apartment.getStreet());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }


    public List<Apartment> select() {

        String printAll = "SELECT * FROM apartment;";

        List<Apartment> getAllApartments = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(printAll)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Apartment apartment = new Apartment();

                apartment.setId(resultSet.getInt("id"));
                apartment.setNumber(resultSet.getInt("number"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setFloor(resultSet.getInt("floor"));
                apartment.setCountRoom(resultSet.getInt("countroom"));
                apartment.setStreet(resultSet.getString("street"));

                getAllApartments.add(apartment);
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }

        return getAllApartments;
    }


    public List<Apartment> filterByCountRoom(int countRoom) {

        String searchApartmentByCountRoom = "SELECT * FROM apartment WHERE countroom = ?";

        List<Apartment> apartmentList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchApartmentByCountRoom)) {

            preparedStatement.setInt(1, countRoom);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Apartment apartment = new Apartment();

                apartment.setId(resultSet.getInt("id"));
                apartment.setNumber(resultSet.getInt("number"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setFloor(resultSet.getInt("floor"));
                apartment.setCountRoom(resultSet.getInt("countroom"));
                apartment.setStreet(resultSet.getString("street"));

                apartmentList.add(apartment);
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }

        return apartmentList;
    }

    public List<Apartment> filterByCountRoomAndFloorInterval(int coumtRoom, int minFloor, int maxFloor) {
        String searchByCountRoomAndFloorInterval = "SElECT * FROM apartment WHERE countroom = ? AND floor BETWEEN ? AND ?;";
        List<Apartment> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchByCountRoomAndFloorInterval)) {

            preparedStatement.setInt(1, coumtRoom);
            preparedStatement.setInt(2, minFloor);
            preparedStatement.setInt(3, maxFloor);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Apartment apartment = new Apartment();

                apartment.setId(resultSet.getInt("id"));
                apartment.setNumber(resultSet.getInt("number"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setFloor(resultSet.getInt("floor"));
                apartment.setCountRoom(resultSet.getInt("countroom"));
                apartment.setStreet(resultSet.getString("street"));

                list.add(apartment);
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }

        return list;
    }

    public List<Apartment> filterApartmentsWithAreaAbove(int area) {

        String searchApartmentWithAreaAbove = "SElECT * FROM apartment WHERE area >= ?;";
        List<Apartment> apartmentList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchApartmentWithAreaAbove)) {

            preparedStatement.setInt(1, area);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Apartment apartment = new Apartment();

                apartment.setId(resultSet.getInt("id"));
                apartment.setNumber(resultSet.getInt("number"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setFloor(resultSet.getInt("floor"));
                apartment.setCountRoom(resultSet.getInt("countroom"));
                apartment.setStreet(resultSet.getString("street"));

                apartmentList.add(apartment);
            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return apartmentList;
    }

    public void updateApartmentByNumber(Apartment apartment) {

        String updateApartment = "UPDATE apartment SET number = ?, area = ?, floor = ?, countroom = ?, street = ? WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateApartment)) {

            preparedStatement.setInt(1, apartment.getNumber());
            preparedStatement.setInt(2, apartment.getArea());
            preparedStatement.setInt(3, apartment.getFloor());
            preparedStatement.setInt(4, apartment.getCountRoom());
            preparedStatement.setString(5, apartment.getStreet());
            preparedStatement.setInt(6, apartment.getId());

            System.out.println("Update successful!");

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public Apartment findById(int id) {
        String findById = "SELECT * FROM apartment WHERE id = ?;";
        Apartment apartment = new Apartment();

        try (PreparedStatement preparedStatement = connection.prepareStatement(findById)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                apartment.setId(resultSet.getInt("id"));
                apartment.setNumber(resultSet.getInt("number"));
                apartment.setArea(resultSet.getInt("area"));
                apartment.setFloor(resultSet.getInt("floor"));
                apartment.setCountRoom(resultSet.getInt("countroom"));
                apartment.setStreet(resultSet.getString("street"));
            }


        } catch (SQLException e) {
            e.getStackTrace();
        }

        return apartment;
    }

    public void deleteApartment(Apartment apartment) {

        String delete = "DELETE FROM apartment WHERE number = ? AND area = ? AND floor = ? AND countroom = ? AND street = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {

            preparedStatement.setInt(1, apartment.getNumber());
            preparedStatement.setInt(2, apartment.getArea());
            preparedStatement.setInt(3, apartment.getFloor());
            preparedStatement.setInt(4, apartment.getCountRoom());
            preparedStatement.setString(5, apartment.getStreet());

            preparedStatement.executeUpdate();

            System.out.println("Delete successful");

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void deleteApartmentById(int id) {

        String deleteById = "DELETE FROM apartment WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteById)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Delete by id successful");

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}