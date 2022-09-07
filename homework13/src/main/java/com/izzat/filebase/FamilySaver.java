package com.izzat.filebase;

import com.izzat.model.Family;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilySaver {
    private static final String path = "family.obj";

    public static void save(List<Family> families) throws RuntimeException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(families);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Family> load() {
        Object obj = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            obj = in.readObject();
            return new ArrayList<>((List<Family>) obj);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}