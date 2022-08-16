package com.izzat.dao.implement;

import com.izzat.Family;
import com.izzat.dao.FamilyDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FamilyCollectionDao implements FamilyDao {

    private final List<Family> fl = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return fl;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return findByIndex(index).orElse(null);
    }


    @Override
    public boolean deleteFamily(int index) {
        if (findByIndex(index).isPresent()) {
            fl.remove(fl.get(index));
            return true;
        }
        return false;
    }

    @Override
    public void saveFamily(Family f) {
        if (findByReference(f).isPresent()) {
            fl.set(fl.indexOf(f), f);
        } else fl.add(f);
    }

    private Optional<Family> findByIndex(int index) {
        Optional<Family> optional = fl.stream()
                .filter(family -> family.equals(fl.get(index)))
                .findFirst();
        return optional;
    }

    private Optional<Family> findByReference(Family f) {
        Optional<Family> optional = fl.stream()
                .filter(family -> family.equals(f))
                .findFirst();
        return optional;
    }


}
