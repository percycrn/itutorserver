package com.usst.springbootitutor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {
    @Id
    @GeneratedValue
    private int tecId;
    private String username;
    private String password;
    private String name;
    private String telenumber;
    private int sex;
    private String subject; // 科目（单选）
    private int tecGrade;
    private String payment; // 所有课时费
    private String tecUrl; // 头像url

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

    public String getTelenumber() {
        return telenumber;
    }

    public void setTelenumber(String telenumber) {
        this.telenumber = telenumber;
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

    public String getTecUrl() {
        return tecUrl;
    }

    public void setTecUrl(String tecUrl) {
        this.tecUrl = tecUrl;
    }
}
