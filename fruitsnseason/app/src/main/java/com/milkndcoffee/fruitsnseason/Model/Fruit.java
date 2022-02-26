package com.milkndcoffee.fruitsnseason.Model;

public class Fruit {
    private int mId;
    private String mName;
    private String mMonths;
    private String mImgSrc;

    public Fruit(){}

    public Fruit(int id, String name, String months, String imgSrc){
    mId = id;
    mName = name;
    mMonths = months;
    mImgSrc = imgSrc;
    }

    public int getId(){return mId;}
    public void setId(int id){this.mId = id;}

    public String getName() {
        return mName;
    }
    public void setName(String name) {
        this.mName = name;
    }

    public String getMonths(){return mMonths;}
    public void setMonths(String months){this.mMonths = months;}


    public String getImgSrc() {
        return mImgSrc;
    }
    public void setImgSrc(String imgSrc) {
        this.mImgSrc = imgSrc;
    }


}
