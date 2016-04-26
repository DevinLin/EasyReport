package com.jd.coo.permission.condition;

import java.io.Serializable;

/**
 * 角色资源关联
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public class RoleResourceRelCondition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 主键
	 */
	private String id;
 	
	/**
	 * 角色id
	 */
	private String roleId;
 	
	/**
	 * 资源id
	 */
	private String resourceId;

 	
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
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}
	
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	
	
	
	/**
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}
	
	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
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