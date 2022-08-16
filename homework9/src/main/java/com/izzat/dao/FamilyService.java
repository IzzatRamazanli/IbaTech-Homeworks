package com.izzat.dao;

import com.izzat.Family;

import java.util.ArrayList;
import java.util.List;

public class FamilyService {
    private final FamilyDao dao;

    public FamilyService(FamilyDao dao) {
        this.dao = dao;
    }

    public List<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public void displayAllFamilies() {
        dao.getAllFamilies().forEach(System.out::println);
    }
}
