package com.lbs.entity;
/**
 * beetl模板，只需要一个简单的POJO类
 * 而不需要Javabean
 * 所以不实现接口(implements Serializable) 也行
 */

import java.io.Serializable;
import java.util.Date;

public class Bloggers {
    private int number; //编号
    private String representative;  //代表人
    private String address;//地址
    private String partname;//名称
    private Date date_add;//加入日期
    private Date contract_expiration;//合约到期时间

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public Date getDate_add() {
        return date_add;
    }

    public void setDate_add(Date date_add) {
        this.date_add = date_add;
    }

    public Date getContract_expiration() {
        return contract_expiration;
    }

    public void setContract_expiration(Date contract_expiration) {
        this.contract_expiration = contract_expiration;
    }
}