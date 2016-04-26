package com.jd.coo.permission.condition;

import java.io.Serializable;

/**
 * 角色表
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public class RoleCondition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 主键
	 */
	private String id;
 	
	/**
	 * 角色代码
	 */
	private String roleCode;
 	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 描述
	 */
	private String description;
 	
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
	
	
	
	
	
	
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
	
	
	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	
	/**
	 * @return the createUser
	 */
	public String getCreateUser() {
		return createUser;
	}
	
	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
	
	
	/**
	 * @return the updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	
	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	
	
	
	/**
	 * @return the yn
	 */
	public String getYn() {
		return yn;
	}
	
	/**
	 * @param yn the yn to set
	 */
	public void setYn(String yn) {
		this.yn = yn;
	}
	
	
	
	
}