package com.pojo;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
    private int account_id;
    private int sid;
    private double money;
    private Student student;
    private List<Info> infos;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    public List<Info> getInfos() {
        return infos;
    }

    public void setInfos(List<Info> infos) {
        this.infos = infos;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", sid=" + sid +
                ", money=" + money +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
