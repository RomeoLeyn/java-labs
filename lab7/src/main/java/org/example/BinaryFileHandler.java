package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BinaryFileHandler {
    private final String path;

    public BinaryFileHandler(String path) {
        this.path = path;
    }

    public void binaryFileWriter(ApartmentSet apartmentSet) {
        try (FileWriter writer = new FileWriter(this.path, true)) {
            writer.write(apartmentSet.toString() + '\n');
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public StringBuilder binaryFileReader() {

        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader reader = new FileReader(this.path)) {

            while (reader.ready()) {
                stringBuilder.append((char) reader.read());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return stringBuilder;
    }
}
