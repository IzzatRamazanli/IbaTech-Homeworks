package com.izzat.dao;

import com.izzat.Family;

import java.util.List;

public class FamilyService {
    private final FamilyDao dao ;

    public FamilyService(FamilyDao dao) {
        this.dao = dao;
    }

    public List<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public void displayAllFamilies() {
        dao.getAllFamilies().forEach(System.out::println);
    }

    public void getFamiliesBiggerThan(int count) {
        getAllFamilies().stream().filter(x -> x.countFamily() > count)
                .toList().forEach(System.out::println);

    }

    public void getFamiliesLessThan(int count) {
        getAllFamilies().stream().filter(x -> x.countFamily() < count)
                .toList().forEach(System.out::println);

    }

}
