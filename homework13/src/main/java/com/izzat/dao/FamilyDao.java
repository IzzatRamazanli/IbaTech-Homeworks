package com.izzat.dao;

import com.izzat.model.Family;

import java.io.FileNotFoundException;
import java.util.List;

public interface FamilyDao {

    List<Family> getAllFamilies();

    Family getFamilyByIndex(int index);

    boolean deleteFamily(int index);

    boolean deleteFamily(Family f);

    void saveFamily(Family f);

    void save();
    void load() throws FileNotFoundException;
}
