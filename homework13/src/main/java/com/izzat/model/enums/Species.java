package com.izzat.model.enums;

public enum Species {
    DOG(false, 4, true),
    DOMESTICCAT(false, 4, true),
    ROBOCAT(false, 4, false),
    FISH(false, 0, false),
    UNKNOWN;

    private boolean canFly;
    private int numberOfLegs;
    private boolean hasFur;

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }
    Species(){

    }

    @Override
    public String toString() {
        return "{" +
                "canFly=" + canFly +
                ", numberOfLegs=" + numberOfLegs +
                ", hasFur=" + hasFur +
                '}';
    }
}
