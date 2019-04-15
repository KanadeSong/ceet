package com.ljj.ceet.entity;

import java.util.Date;

public class DocumentInf {
    private String id;

    private String title;

    private String filename;

    private String remark;

    private Date createDate;

    private Integer userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {

        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DocumentInf{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", filename='" + filename + '\'' +
                ", remark='" + remark + '\'' +
                ", createDate=" + createDate +
                ", userId=" + userId +
                '}';
    }
}