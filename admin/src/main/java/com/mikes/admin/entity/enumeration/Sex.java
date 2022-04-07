package com.mikes.admin.entity.enumeration;

public enum Sex {
    FELMALE("女", 0),
    MALE("男", 1);

    private String sex;
    private int index;

    Sex(String sex, int index) {
        this.sex = sex;
        this.index = index;
    }

    public static String getSex(int index){
        for (Sex s : Sex.values()){
            if (s.index == index){
                return s.sex;
            }
        }
        return null;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
