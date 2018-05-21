package com.usst.springbootitutor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Class {
    @Id
    @GeneratedValue
    private int classId;
    private String className;
    private String tecName; // 老师姓名
    private String stuName; // 学生姓名
    private String subject; // 老师的授课内容
    private String tecTelenumber; // 老师手机号
    private String stuTelenumber; // 学生手机号
    private String classTime; // 单选 即周一到周日中的某一天
    private int start; // 一年中的第五周就是5
    private int end;
    private int pay; // 这节课的收费

    public Class() {
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTecTelenumber() {
        return tecTelenumber;
    }

    public void setTecTelenumber(String tecTelenumber) {
        this.tecTelenumber = tecTelenumber;
    }

    public String getStuTelenumber() {
        return stuTelenumber;
    }

    public void setStuTelenumber(String stuTelenumber) {
        this.stuTelenumber = stuTelenumber;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTecName() {
        return tecName;
    }

    public void setTecName(String tecName) {
        this.tecName = tecName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
