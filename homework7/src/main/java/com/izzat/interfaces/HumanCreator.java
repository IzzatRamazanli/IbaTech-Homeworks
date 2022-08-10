package com.izzat.interfaces;

import com.izzat.Family;
import com.izzat.Human;

public interface HumanCreator {
    Human bornChild(Family family, Human father);
}
