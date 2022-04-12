package com.mikes.admin.entity.enumeration;

public enum Sex {
    FELMALE(0, "女"),
    MALE(1, "男");

    private int index;
    private String desc;

    Sex( int index,String desc) {
        this.desc = desc;
        this.index = index;
    }

    public static String getSex(int index){
        for (Sex s : Sex.values()){
            if (s.index == index){
                return s.desc;
            }
        }
        return null;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
