package com.legerito.practice.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {
         Path path = Path.of("files/testing.txt");
         int pathParts = path.getNameCount();
         logStatement(path);
//         extrainfo(path);
    }   

    private static void logStatement(Path path) {

        try {
            Path parent = path.getParent();
            if(!Files.exists(parent)) {
                Files.createDirectories(parent);
            }

            Files.writeString(path, Instant.now() + ": hello file world\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extrainfo(Path path) {
        try {
            var atts = Files.readAttributes(path,"*");
            atts.entrySet().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
