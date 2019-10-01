package com.ccu.model;

public class Goods {
    private String goodsId;
    private String goodsName;
    private String classificationNum;
    private double price;
    private int stock;

    public Goods(){}

    public Goods(String goodsId, String goodsName, String classificationNum, double price, int stock) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.classificationNum = classificationNum;
        this.price = price;
        this.stock = stock;
    }

    public String getgoodsId() {
        return goodsId;
    }

    public void setgoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getClassificationNum() {
        return classificationNum;
    }

    public void setClassificationNum(String classificationNum) {
        this.classificationNum = classificationNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
