package com.usst.springbootitutor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private int stu_id;
    private String username;
    private String password;
    private String name;
    private int sex; // 1是女生 2是男生
    private int age;
    private int stu_grade; // 一年级为1，逐级递增，高三为12
    private String telenumber;
    private String pay_password;
    private int balances; // 余额数目

    public Student() {
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStu_grade() {
        return stu_grade;
    }

    public void setStu_grade(int stu_grade) {
        this.stu_grade = stu_grade;
    }

    public String getTelenumber() {
        return telenumber;
    }

    public void setTelenumber(String telenumber) {
        this.telenumber = telenumber;
    }

    public String getPay_password() {
        return pay_password;
    }

    public void setPay_password(String pay_password) {
        this.pay_password = pay_password;
    }

    public int getBalances() {
        return balances;
    }

    public void setBalances(int balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", stu_grade=" + stu_grade +
                ", telenumber='" + telenumber + '\'' +
                ", pay_password='" + pay_password + '\'' +
                ", balances=" + balances +
                '}';
    }
}
