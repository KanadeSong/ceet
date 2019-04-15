package com.ljj.ceet.vo;

import java.util.Date;

/**
 * @CLassName UserVO
 * @Description TODO
 * @Author LeeJack
 * @Date 2019/4/14/014 11:19
 * @Version 1.0
 */
public class UserVO {
    private Integer id;

    private String loginname;

    private String password;

    private Integer status;

    private Date createdate;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
