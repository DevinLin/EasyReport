package com.jd.coo.system.condition;

import java.io.Serializable;

/**
 * 用户系统表
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-29 下午 06:03:12
 */
public class UserDeptCondition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 主键
	 */
	private String id;
 	


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
	 * 创建时间
	 */
	private String createTime;
 	
	/**
	 * 更新时间
	 */
	private String updateTime;
 	
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
	private String yn;
 	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
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

	public String getYn() {
		return yn;
	}

	public void setYn(String yn) {
		this.yn = yn;
	}

   
}