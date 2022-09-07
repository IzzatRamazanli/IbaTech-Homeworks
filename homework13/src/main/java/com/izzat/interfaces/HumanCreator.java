package com.izzat.interfaces;

import com.izzat.model.Family;
import com.izzat.model.Human;

import java.text.ParseException;

public interface HumanCreator {
    Human bornChild(Family family, Human father) throws ParseException;
}
