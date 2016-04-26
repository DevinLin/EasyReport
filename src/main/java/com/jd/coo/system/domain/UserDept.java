package com.jd.coo.system.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户系统表
 * @org logisticss.jd.com 
 * @author jianglongfei
 * @Date 2015-07-29 下午 06:03:12
 */
public class UserDept implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Long id;

	
    /**
     * 用户编号
     */
    private String userNo;


    /**
     * 用户编号
     */
    private String userName;
    
    
    /**
     * 用户编号
     */
    private String email;
    
    
    /**
     * 用户编号
     */
    private String tel;
	
	
	
    /**
     * 系统代码
     */
    private String deptCode;

    /**
     * 系统代码
     */
    private String deptName;
    
    
    private byte admin;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 创建人
	 */
	private String createUser;
	
	/**
	 * 更新人
	 */
	private String updateUser;
	
	/**
	 * 删除标志
	 */
	private byte yn;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public byte getYn() {
		return yn;
	}

	public void setYn(byte yn) {
		this.yn = yn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public byte getAdmin() {
		return admin;
	}

	public void setAdmin(byte admin) {
		this.admin = admin;
	}

   
	
}