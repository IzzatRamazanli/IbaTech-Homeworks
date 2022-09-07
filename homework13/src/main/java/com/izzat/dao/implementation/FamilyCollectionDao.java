package com.izzat.dao.implementation;

import com.izzat.filebase.FamilySaver;
import com.izzat.model.Family;
import com.izzat.dao.FamilyDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FamilyCollectionDao implements FamilyDao {

    private List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return findByIndex(index).orElse(null);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (findByIndex(index).isPresent()) {
            families.remove(families.get(index));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family f) {
        if (findByReference(f).isPresent()) {
            families.remove(f);
            return true;
        }
        return false;
    }

    @Override
    public void saveFamily(Family f) {
        if (findByReference(f).isPresent()) {
            families.set(families.indexOf(f), f);
        } else families.add(f);
    }

    @Override
    public void save() {
        FamilySaver.save(families);
    }

    @Override
    public void load() {
        families = FamilySaver.load();
    }

    private Optional<Family> findByIndex(int index) {
        return families.stream()
                .filter(family -> family.equals(families.get(index)))
                .findFirst();
    }

    private Optional<Family> findByReference(Family f) {
        return families.stream()
                .filter(family -> family.equals(f))
                .findFirst();

    }


}
