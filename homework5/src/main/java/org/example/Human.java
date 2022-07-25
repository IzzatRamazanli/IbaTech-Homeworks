package org.example;

import java.util.Arrays;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    //Advanced complexity static and non-static initialisation
    static {
        System.out.println(Human.class.getName().substring(12) + " class loaded");
    }

    {
        System.out.println("New object is created: " + this.getClass().getTypeName().substring(12));
    }


    //overriding toString
    @Override
    public String toString() {
        if (iq == 0 && schedule.length == 0) {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    '}';
        }
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + Arrays.deepToString(schedule) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Human)) return false;

        Human human = (Human) obj;

        return this.name.equals(human.name) &&
                this.surname.equals(human.surname) &&
                this.year == human.year;
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.setName(name);
        this.setSurname(surname);
        this.setYear(year);
        this.setIq(iq);
        this.setSchedule(schedule);
    }

    public Human() {
    }

    public Human(String name, String surname, int year) {
        this.setName(name);
        this.setSurname(surname);
        this.setYear(year);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }


    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

}
