package com.legerito.practice.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

public class FileListings {

    public static void main(String[] args) {

        Path path = Path.of("");

        try (Stream<Path> paths = Files.walk(path, 1)) {
            paths.map(FileListings::listDir)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String listDir(Path path) {

        try {
            boolean isDir = Files.isDirectory(path);
            FileTime fileTime = Files.getLastModifiedTime(path);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(fileTime.toInstant(), ZoneId.systemDefault());
            return "%tD %tT %-10s %-10s %s".formatted(localDateTime, localDateTime, (isDir ? "<DIR>" : ""), (isDir ? "" : Files.size(path)), path);
        } catch (IOException e) {
            System.out.println("Error occurred");
            return path.toString();
        }
    }
}
