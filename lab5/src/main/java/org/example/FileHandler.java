package org.example;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileHandler {

    private String path;

    public FileHandler(String path) {
        this.path = path;
    }

    public ApartmentProcess readFileByGson() {
        Gson gson = new Gson();

        try(FileReader fileReader = new FileReader(this.path)) {
            ApartmentProcess apartmentProcess = gson.fromJson(fileReader, ApartmentProcess.class);
            return apartmentProcess;
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }


    public boolean writeFile(ApartmentProcess apartmentProcess) {
        Gson gson = new Gson();

        boolean isWritten = false;

        try (FileWriter writer = new FileWriter(this.path)) {
            gson.toJson(apartmentProcess, writer);
            isWritten = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return isWritten;
    }
}