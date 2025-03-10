package ua.univer.util;

import ua.univer.exeptions.MyException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static ua.univer.config.AppConfiguration.DIRECTORY;

public class FileUtil {

    private FileUtil() {
    }


    public static void writeStringToFile(String str, String prefix, String suffix){
        File file;
        try {
            Path tempRequest = Files.createTempFile(Path.of(DIRECTORY), prefix, suffix);
            file = new File(tempRequest.toString());
            Files.writeString(file.toPath(), str);
        } catch (IOException e) {
            throw new MyException("Error in method writeStringToFile");
        }
    }


}
