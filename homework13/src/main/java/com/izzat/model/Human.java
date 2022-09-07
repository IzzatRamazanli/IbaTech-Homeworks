package com.izzat.model;

import com.izzat.model.enums.DayOfWeek;
import com.izzat.model.humans.Man;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Human implements Serializable {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private static final long serialVersionID = 1L;
    private String name;
    private String gender;
    private String surname;
    private long birthDate;
    private int iq;
    private Map<DayOfWeek, String> schedule;
    private Family family;

    { // non-static initializer for setting gender properly
        if (this instanceof Man) {
            this.gender = "Boy";
        } else {
            this.gender = "Girl";
        }
    }

    public Human(String name, String surname, String birthDate, int iq, Map<DayOfWeek, String> schedule, Family family) throws ParseException {
        this.setName(name);
        this.setSurname(surname);
        this.setIq(iq);
        this.setSchedule(schedule);
        this.setFamily(family);
        this.birthDate = getFormattedDate(birthDate).getTime();
    }

    public Human() {
    }

    public Human(String name, String surname, String birthDate, int iq) throws ParseException {
        this.setName(name);
        this.setSurname(surname);
        this.setIq(iq);
        this.setSchedule(schedule);
        this.birthDate = getFormattedDate(birthDate).getTime();
    }

    public Human(String name, String surname, String birthDate) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birthDate = getFormattedDate(birthDate).getTime();
    }

    private Date getFormattedDate(String birthDate) throws ParseException {
        return SDF.parse(birthDate);
    }

    public void describeAge() {
        long current = System.currentTimeMillis() / 1000;
        long duration = current - birthDate / 1000;
        long days = duration / 86400;
        long month = days / 30;
        long year = month / 12;
        System.out.printf("days = %d, months = %d, years = %d", days, month, year);
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

    public int getBirthYear() throws ParseException {
        return getFormattedDate(SDF.format(birthDate)).getYear();
    }

    public String getBirthDate() {
        return String.valueOf(SDF.format(birthDate));
    }

    public int getAge() {
        String year = SDF.format(birthDate).substring(6); //yyyy
        return LocalDate.now().getYear() - Integer.parseInt(year);
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = getFormattedDate(birthDate).getTime();
    }

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
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
        this.gender = gender;
    }

    @Override
    public String toString() {
        return prettyFormat();
    }

    private String prettyFormat() {
        if (iq == 0 && schedule == null) {
            return "{name='%s', surname='%s', birthDate=%s}\n"
                    .formatted(name, surname, SDF.format(birthDate));
        } else if (schedule == null) {
            return "{name='%s', surname='%s', birthDate=%s, iq=%d}\n"
                    .formatted(name, surname, SDF.format(birthDate), iq);
        }
        return "{name='%s', surname='%s', birthDate=%s, iq=%d, schedule=%s}\n"
                .formatted(name, surname, SDF.format(birthDate), iq, schedule);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Human)) return false;

        Human human = (Human) obj;

        return this.name.equals(human.name) &&
                this.surname.equals(human.surname) &&
                this.birthDate == human.birthDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname, this.birthDate);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.name + " object collected by Garbage Collector");
    }
}
