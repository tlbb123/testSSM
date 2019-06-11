package com.pojo;

import java.io.Serializable;
import java.util.Date;

public class Info implements Serializable {
    private int info_id;
    private int aid;
    private String info_change;
    private Date date;
    private Account account;

    @Override
    public String toString() {
        return "Info{" +
                "info_id=" + info_id +
                ", aid=" + aid +
                ", info_change='" + info_change + '\'' +
                ", date=" + date +
                '}';
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getInfo_id() {
        return info_id;
    }

    public void setInfo_id(int info_id) {
        this.info_id = info_id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getInfo_change() {
        return info_change;
    }

    public void setInfo_change(String info_change) {
        this.info_change = info_change;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
