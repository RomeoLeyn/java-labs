package org.example;

import java.io.*;

public class BinaryFileHandler {

    private String path;

    public BinaryFileHandler(String path) {
        this.path = path;
    }

    public boolean BinaryFileWriter(ApartmentProcess apartmentProcess) {
        boolean isWritten = false;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.path))) {
            oos.writeObject(apartmentProcess);
            isWritten = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return isWritten;
    }

    public ApartmentProcess BinaryFileReader() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.path))) {
            ApartmentProcess apartmentProcess = (ApartmentProcess) ois.readObject();
            return apartmentProcess;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
