package com.izzat;

import com.izzat.abstracts.Pet;
import com.izzat.dao.FamilyController;
import com.izzat.dao.FamilyDao;
import com.izzat.dao.FamilyService;
import com.izzat.dao.implementation.FamilyCollectionDao;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;
import com.izzat.pets.Dog;
import com.izzat.pets.DomesticCat;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        FamilyApplication app = new FamilyApplication();
        while (app.start()) {
            if (!app.start()) break;
        }
    }
}
