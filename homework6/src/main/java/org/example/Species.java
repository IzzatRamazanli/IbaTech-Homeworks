package org.example;

public enum Species {
    DOG(false, 4, true),
    CAT(false, 4, true),
    BIRD(true, 2, false),
    SPIDER(false, 8, false),
    FISH(false, 0, false);

    private boolean canFly;
    private int numberOfLegs;
    private boolean hasFur;

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
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
