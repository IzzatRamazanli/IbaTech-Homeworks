package com.izzat.dao.implementation;

import com.izzat.filebase.FamilySaver;
import com.izzat.logging.Logger;
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
            Logger.info("Family with index " + index + " deleted");
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family f) {
        if (findByReference(f).isPresent()) {
            families.remove(f);
            Logger.info(f.getFather().getSurname()+" family deleted");
            return true;
        }
        return false;
    }

    @Override
    public void saveFamily(Family f) {
        if (findByReference(f).isPresent()) {
            families.set(families.indexOf(f), f);
        } else families.add(f);
        Logger.info(f.getFather().getSurname()+" family saved");
    }

    @Override
    public void save() {
        FamilySaver.save(families);
        Logger.info("Families saved to file");
    }

    @Override
    public void load() {
        families = FamilySaver.load();
        Logger.info("Family loaded from file");
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
