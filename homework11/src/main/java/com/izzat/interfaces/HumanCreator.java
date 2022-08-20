package com.izzat.interfaces;

import com.izzat.Family;
import com.izzat.Human;

import java.text.ParseException;

public interface HumanCreator {
    Human bornChild(Family family, Human father) throws ParseException;
}
