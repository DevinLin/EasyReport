package com.jd.coo.permission.manager.impl;


import com.jd.coo.common.Page;
import com.jd.coo.permission.condition.UserCondition;
import com.jd.coo.permission.dao.UserDao;
import com.jd.coo.permission.dao.UserRoleRelDao;
import com.jd.coo.permission.domain.User;
import com.jd.coo.permission.manager.UserManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户表管理器实现
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
@Component("UserManagerImpl")
public class UserManagerImpl implements UserManager {

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(UserManagerImpl.class);
	/**
	 * the UserDao
	 */
	@Resource
	private UserDao userDao;
	@Resource
	private UserRoleRelDao userRoleRelDao;
	
	
	/*===============================================================================*/
	/*                                以下是增删改查方法
	/*===============================================================================*/
	/**
	 * 获取用户表
	 * @param id
	 * @return the User
	 */
	public User getUser(Long id) {
		User user = userDao.getUser(id);
		return user;
	}

	
	public Page findUserList(Page page, UserCondition userCondition) {
		page.setRows(userDao.findUserList(page, userCondition));
		return page;
	}
	/**
	 * 插入用户表
	 * @param user
	 */
   // @Transactional
	public void insertUser(User user) {
	     Date date = new Date();
	     user.setYn((byte)1);
		 user.setCreateTime(date);
		 user.setUpdateTime(date);
		userDao.insertUser(user);
       
	}
	/**
	 * 更新用户表
	 * @param user
	 */
	public void updateUser(User user) {
	     user.setUpdateTime(new Date());
		userDao.updateUser(user);

	}

	/**
	 * 删除用户表
	 * @param id
	 */
	public void deleteUser(Long id) {
		//删除角色
		userRoleRelDao.deleteUserRoleRel(id);
		userDao.deleteUser(id);
	}
	/**
	 * 批量删除用户表
	 */
	public void deleteUserBatch(Long[] ids) {
		 userDao.deleteUserBatch(ids);
	}
	
	/*===============================================================================*/
	/*                                以下是get/set方法
	/*===============================================================================*/
	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return this.userDao;
	}
	
	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-main.xml");
		UserManager um = (UserManager)ac.getBean("UserManagerImpl");
		User user = new User();
		user.setUserName("linlingyue");
		user.setUserCode("linlingyue");
		user.setDescription("linlingyue");

		um.insertUser(user);
	}

}
