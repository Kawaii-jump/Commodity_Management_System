package com.ccu.model;

import java.util.Date;

public class Order {
    private int number;
    private String goodsId;
    private int goodsNum;
    private double price;
    private Date orderDate;

    public Order(){}

    public Order(int number, String goodsId, int goodsNum, double price, Date orderDate) {
        this.number = number;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.price = price;
        this.orderDate = orderDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
