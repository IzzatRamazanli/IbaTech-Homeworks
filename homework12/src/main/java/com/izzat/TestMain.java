package com.izzat;


import java.text.ParseException;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws ParseException {
        HappyFamilyApp app = new HappyFamilyApp();
        while (app.start()) {
            if (!app.start()) break;
        }
    }
}
