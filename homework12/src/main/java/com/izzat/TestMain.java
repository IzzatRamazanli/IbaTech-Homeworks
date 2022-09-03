package com.izzat;


import java.text.ParseException;


public class TestMain {
    public static void main(String[] args) throws ParseException {
        FamilyApplication app = new FamilyApplication();
        while (app.start()) {
            if (!app.start()) break;
        }
    }
}
