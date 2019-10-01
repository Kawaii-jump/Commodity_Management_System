package com.ccu.model;

public class ClassGoods {
    private String classificationNum;
    private String classification;

    public ClassGoods(){}

    public ClassGoods(String classificationNum, String classification) {
        this.classificationNum = classificationNum;
        this.classification = classification;
    }

    public String getClassificationNum() {
        return classificationNum;
    }

    public void setClassificationNum(String classificationNum) {
        this.classificationNum = classificationNum;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
