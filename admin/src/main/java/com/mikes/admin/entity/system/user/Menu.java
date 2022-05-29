package com.mikes.admin.entity.system.user;

public class Menu {
    private int id;
    private int parentId;
    private String parentName;
    private String menuName;
    private String href;
    private String link;
    private int sort;
    private int display;            //0:显示，1:隐藏
    private String disp;
    private int level;              //等级：1、顶级菜单，2、侧边菜单
    private String lev;
    private String remarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", parentName='" + parentName + '\'' +
                ", menuName='" + menuName + '\'' +
                ", link='" + link + '\'' +
                ", sort=" + sort +
                ", display=" + display +
                ", disp='" + disp + '\'' +
                ", level=" + level +
                ", lev='" + lev + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
