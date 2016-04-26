package com.jd.coo.system.manager.impl;

import com.jd.coo.common.Page;
import com.jd.coo.system.condition.UserDeptCondition;
import com.jd.coo.system.dao.UserDeptDao;
import com.jd.coo.system.domain.UserDept;
import com.jd.coo.system.manager.UserDeptManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户系统表管理器实现
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-29 下午 06:03:12
 */
@Component
public class UserDeptManagerImpl implements UserDeptManager {

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(UserDeptManagerImpl.class);
	/**
	 * the UserDeptDao
	 */
	@Resource
	private UserDeptDao userDeptDao;

	public Page findUserDeptList(Page page, UserDeptCondition userDeptCondition) {
		page.setRows(userDeptDao.findUserDeptList(page, userDeptCondition));
		return page;
	}
	
	/**
	 * 插入用户系统表
	 * @param userDept
	 */
	public void insertUserDept(UserDept userDept) {
	     Date date = new Date();
	     userDept.setYn((byte)1);
		 userDept.setCreateTime(date);
		 userDept.setUpdateTime(date);
		userDeptDao.insertUserDept(userDept);
	}


	/**
	 * 删除用户系统表
	 * @param id
	 */
	public void deleteUserDept(Long id) {
		userDeptDao.deleteUserDept(id);
	}


	/*===============================================================================*/
	/*                                以下是get/set方法
	/*===============================================================================*/
	/**
	 * @return the userDeptDao
	 */
	public UserDeptDao getUserDeptDao() {
		return this.userDeptDao;
	}
	
	/**
	 * @param userDeptDao the userDeptDao to set
	 */
	public void setUserDeptDao(UserDeptDao userDeptDao) {
		this.userDeptDao = userDeptDao;
	}

	public int findUserDeptCount(UserDept userDept) {
		return userDeptDao.findUserDeptCount(userDept);
	}

	public void setAdmin(UserDeptCondition userDeptCondition) {
		UserDept userDept = new UserDept();
		userDept.setId(Long.parseLong(userDeptCondition.getId()));
		userDept.setAdmin((byte)1);
		userDeptDao.updateAdminUserDeptByDeptCode(userDeptCondition.getDeptCode());
		userDeptDao.updateUserDept(userDept);
	}
}
