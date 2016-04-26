package com.jd.coo.system.service.impl;

import com.jd.coo.common.Page;
import com.jd.coo.system.condition.UserDeptCondition;
import com.jd.coo.system.domain.UserDept;
import com.jd.coo.system.manager.UserDeptManager;
import com.jd.coo.system.service.UserDeptService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户系统表服务实现
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-29 下午 06:03:12
 */
@Component("userDeptService")
public class UserDeptServiceImpl implements UserDeptService {

	/**
	 * Logger for this class
	 */
	 private static final Logger log = Logger.getLogger(UserDeptServiceImpl.class);
	/**
	 * the UserDeptManager
	 */
	private UserDeptManager userDeptManager;


	/*
	 * (non-Javadoc)
	 * @see com.jd.logistics.base.portal.service.UserDeptService\#add(com.jd.logistics.base.portal.domain.UserDept)
	 */
	public void insertUserDept(UserDept userDept) {
		userDeptManager.insertUserDept(userDept);
	}

	/*
	 * (non-Javadoc)
	 * @seecom.jd.logistics.base.portal.service.UserDeptService\#delete(java.lang.Long)
	 */
	public void deleteUserDept(Long id) {
		userDeptManager.deleteUserDept(id);
	}


	public Page findUserDeptList(Page page,UserDeptCondition userDeptCondition) {
		return userDeptManager.findUserDeptList(page, userDeptCondition);
	}

	public int findUserDeptCount(UserDept userDept) {
		return userDeptManager.findUserDeptCount(userDept);
	}
	public void setAdmin(UserDeptCondition userDeptCondition) {
		 userDeptManager.setAdmin(userDeptCondition);
	}
	
}
