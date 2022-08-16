package com.izzat.dao;

import com.izzat.Family;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FamilyCollectionDao implements FamilyDao {

    private final List<Family> fl = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return fl;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (fl.contains(fl.get(index))) return fl.get(index);
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        return false;
    }

    @Override
    public void saveFamily(Family f) {
        fl.add(f);
    }


}
