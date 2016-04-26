package com.jd.coo.permission.manager.impl;


import com.jd.coo.common.Page;
import com.jd.coo.permission.condition.UserRoleRelCondition;
import com.jd.coo.permission.dao.UserRoleRelDao;
import com.jd.coo.permission.domain.UserRoleRel;
import com.jd.coo.permission.manager.UserRoleRelManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户角色关联表管理器实现
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
@Component
public class UserRoleRelManagerImpl implements UserRoleRelManager {

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(UserRoleRelManagerImpl.class);
	/**
	 * the UserRoleRelDao
	 */
	@Resource
	private UserRoleRelDao userRoleRelDao;
	
	
	
	/*===============================================================================*/
	/*                                以下是增删改查方法
	/*===============================================================================*/
	/**
	 * 获取用户角色关联表
	 * @param id
	 * @return the UserRoleRel
	 */
	
	public UserRoleRel getUserRoleRel(Long id) {
		UserRoleRel userRoleRel = userRoleRelDao.getUserRoleRel(id);
		return userRoleRel;
	}

    /**
     * 获取用户角色关联表列表
     * @param userRoleRelCondition
     * @return the UserRoleRel
     */
    public List findUserRoleRelListByCondition(UserRoleRelCondition userRoleRelCondition){
        return userRoleRelDao.findUserRoleRelListByCondition(userRoleRelCondition);
    }
	public List findUserRoleRelList( UserRoleRelCondition userRoleRelCondition) {
		return userRoleRelDao.findUserRoleRelList(userRoleRelCondition);
	}

    public List findUserRoleRelList(Page page, UserRoleRelCondition userRoleRelCondition) {
        return userRoleRelDao.findUserRoleRelList(page,userRoleRelCondition);
    }

    /**
	 * 插入用户角色关联表
	 * @param userRoleRel
	 */
	public void insertUserRoleRel(UserRoleRel userRoleRel) {
	     Date date = new Date();
	     userRoleRel.setYn((byte)1);
		 userRoleRel.setCreateTime(date);
		 userRoleRel.setUpdateTime(date);
		userRoleRelDao.insertUserRoleRel(userRoleRel);
	}
    /**
     * 插入用户角色关联表
     * @param userId
     */
    public void batchInsertUserRoleRel(Long userId,Long[] roleIds) {
        userRoleRelDao.deleteUserRoleRel(userId);
        userRoleRelDao.batchInsertUserRoleRel(userId,roleIds);
    }


	
	/*===============================================================================*/
	/*                                以下是get/set方法
	/*===============================================================================*/
	/**
	 * @return the userRoleRelDao
	 */
	public UserRoleRelDao getUserRoleRelDao() {
		return this.userRoleRelDao;
	}
	
	/**
	 * @param userRoleRelDao the userRoleRelDao to set
	 */
	public void setUserRoleRelDao(UserRoleRelDao userRoleRelDao) {
		this.userRoleRelDao = userRoleRelDao;
	}
	
}
