package com.izzat.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {
    private static final String path = "application.log";

    private static void log(String msg, Process p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")) + " " + msg + "[ " + p + " ]" + "\n");
        } catch (IOException x) {
            System.out.println(x.getMessage());
        }
    }

    public static void info(String msg) {
        log(msg, Process.DEBUG);
    }

    public static void error(String msg) {
        log(msg, Process.ERROR);
    }
}
