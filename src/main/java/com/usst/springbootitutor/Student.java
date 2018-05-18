package com.usst.springbootitutor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int stuId;
    private String username;
    private String password;
    private String name;
    private int sex; // 1是女生 2是男生
    private int age;
    private int stuGrade; // 一年级为1，逐级递增，高三为12
    private String telenumber;
    private String payPassword;
    private int balances; // 余额数目
    private String stuUrl; // 学生头像url

    public Student() {
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
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

    public int getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(int stuGrade) {
        this.stuGrade = stuGrade;
    }

    public String getTelenumber() {
        return telenumber;
    }

    public void setTelenumber(String telenumber) {
        this.telenumber = telenumber;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
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
                "stuId=" + stuId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", stuGrade=" + stuGrade +
                ", telenumber='" + telenumber + '\'' +
                ", payPassword='" + payPassword + '\'' +
                ", balances=" + balances +
                '}';
    }

    public String getStuUrl() {
        return stuUrl;
    }

    public void setStuUrl(String stuUrl) {
        this.stuUrl = stuUrl;
    }
}
