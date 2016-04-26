package com.jd.coo.permission.manager;


import com.jd.coo.common.Page;
import com.jd.coo.permission.condition.UserRoleRelCondition;
import com.jd.coo.permission.domain.UserRoleRel;

import java.util.List;

/**
 * 用户角色关联表管理器
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface UserRoleRelManager {

	/**
	 * 获取用户角色关联表
	 * @param id
	 * @return the UserRoleRel
	 */
	public UserRoleRel getUserRoleRel(Long id);


    /**
     * 获取用户角色关联表列表
     * @param userRoleRelCondition
     * @return the UserRoleRel
     */
    public List findUserRoleRelListByCondition(UserRoleRelCondition userRoleRelCondition);

    /**
	 * 获取用户角色关联表列表
	 * @param userRoleRelCondition
	 * @return the UserRoleRel
	 */
	public List findUserRoleRelList(UserRoleRelCondition userRoleRelCondition);


    /**
     * 获取用户角色关联表列表
     * @param page
     * @return the UserRoleRel
     */
    public List findUserRoleRelList(Page page, UserRoleRelCondition userRoleRelCondition);
	
	/**
	 * 插入用户角色关联表
	 * @param userRoleRel
	 */
	public void insertUserRoleRel(UserRoleRel userRoleRel);

    public void batchInsertUserRoleRel(Long userId, Long[] roleIds);
}
