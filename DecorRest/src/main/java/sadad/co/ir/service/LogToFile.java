package sadad.co.ir.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public enum LogToFile {

    INSTANCE;

    public void logToFile(String text){
        try (FileWriter file = new FileWriter("/tmp/log.txt", true)) {
            file.write(text + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
