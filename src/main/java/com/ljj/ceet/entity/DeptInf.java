package com.ljj.ceet.entity;

public class DeptInf {
    private String id;

    private String name;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {

        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "DeptInf{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}