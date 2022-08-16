package com.izzat.dao;

import com.izzat.Family;
import com.izzat.dao.implement.FamilyCollectionDao;

import java.util.ArrayList;
import java.util.List;

public class FamilyService {
    private final FamilyDao dao = new FamilyCollectionDao();


    public List<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public void displayAllFamilies() {
        dao.getAllFamilies().forEach(System.out::println);
    }
}
