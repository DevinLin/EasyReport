package com.jd.coo.permission.manager;


import com.jd.coo.common.Page;
import com.jd.coo.permission.condition.UserCondition;
import com.jd.coo.permission.domain.User;

/**
 * 用户表管理器
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface UserManager {

	/**
	 * 获取用户表
	 * @param id
	 * @return the User
	 */
	public User getUser(Long id);

	
	/**
	 * 获取用户表列表
	 * @param id
	 * @return the User
	 */
	public Page findUserList(Page page, UserCondition userCondition);

	/**
	 * 插入用户表
	 * @param user
	 */
	public void insertUser(User user);

	/**
	 * 更新用户表
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 删除用户表
	 * @param id
	 */
	public void deleteUser(Long id);
	
	/**
	 * 批量删除用户表
	 * @param id
	 */
	public void deleteUserBatch(Long[] ids);

}
