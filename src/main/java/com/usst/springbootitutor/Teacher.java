package com.usst.springbootitutor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
    @Id
    private int tecId;
    private String username;
    private String password;
    private String name;
    private String phoneNumber;
    private int sex;
    private String subject; // 科目（单选）
    private int tecGrade;
    private String payment; // 所有课时费

    public Teacher() {
    }

    public int getTecId() {
        return tecId;
    }

    public void setTecId(int tecId) {
        this.tecId = tecId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTecGrade() {
        return tecGrade;
    }

    public void setTecGrade(int tecGrade) {
        this.tecGrade = tecGrade;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
