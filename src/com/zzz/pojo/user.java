package com.zzz.pojo;

import java.util.Date;

public class user {
 
	
	private Integer userid;

    private String username;

    private String realname;

    private String password;

    private Boolean isadmin;

    private Date createTime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
	public String toString() {
		return "user [userid=" + userid + ", username=" + username + ", realname=" + realname + ", password=" + password
				+ ", isadmin=" + isadmin + ", createTime=" + createTime + "]";
	}

	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}