package com.usst.springbootitutor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Timetable {
    @Id
    private String tecId;
    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;
    private String sun;

    public Timetable() {
    }

    public String getTecId() {
        return tecId;
    }

    public void setTecId(String tecId) {
        this.tecId = tecId;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue;
    }

    public String getWed() {
        return wed;
    }

    public void setWed(String wed) {
        this.wed = wed;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }
}
