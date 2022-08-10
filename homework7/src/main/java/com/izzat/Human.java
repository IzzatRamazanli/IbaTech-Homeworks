package com.izzat;

import com.izzat.humans.Man;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String gender;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    public Human(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        this.setName(name);
        this.setSurname(surname);
        this.setYear(year);
        this.setIq(iq);
        this.setSchedule(schedule);
        this.setFamily(family);

        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }
    }

    public Human() {
        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }
    }

    public Human(String name, String surname, int year, int iq) {
        this.setName(name);
        this.setSurname(surname);
        this.setYear(year);
        this.setIq(iq);
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
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

    public void greetPet() {
        System.out.println("Hello");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }
    }

    //overriding toString
    @Override
    public String toString() {
        if (iq == 0 && schedule == null) {
            return gender + "{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    '}';
        } else if (schedule == null) {
            return gender + "{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    ", iq=" + iq +
                    '}';
        }
        return gender + "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + Arrays.deepToString(schedule) +
                '}';
    }

    //overriding equals
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

    //overriding hashcode
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname, this.year);
    }

    //overriding finalize
    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.name + " object collected by Garbage Collector");
    }
}
