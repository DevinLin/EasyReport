package com.jd.coo.permission.condition;

import java.io.Serializable;

/**
 * 资源
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public class BsResourceCondition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 主键
	 */
	private String id;
 	
	/**
	 * 父资源id
	 */
	private String parent_id;
 	
	/**
	 * 资源名称
	 */
	private String name;
	
	
	private String userCode;
	
	
	private String code;
 	
	/**
	 * 资源类型(系统、菜单、页面)
	 */
	private String type;
 	
	/**
	 * 资源url
	 */
	private String url;
 	
	/**
	 * 资源排序
	 */
	private String seq;
 	
	/**
	 * 资源描述
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
	
	
	
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the parent_id
	 */
	public String getParent_id() {
		return parent_id;
	}
	
	/**
	 * @param parent_id the parent_id to set
	 */
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	/**
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}
	
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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