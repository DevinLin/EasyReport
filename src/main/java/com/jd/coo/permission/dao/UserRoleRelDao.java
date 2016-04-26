package com.jd.coo.permission.dao;


import com.jd.coo.common.Page;
import com.jd.coo.permission.condition.UserRoleRelCondition;
import com.jd.coo.permission.domain.UserRoleRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色关联表Dao
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface UserRoleRelDao {

	/**
	 * 获取用户角色关联表
	 * @param id
	 * @return the UserRoleRel
	 */
	public UserRoleRel getUserRoleRel(Long id);

	/**  
	* @Description: 按条件获取用户角色关联表列表
	* @param userRoleRelCondition
	* @return 
	*/
	public List findUserRoleRelList(@Param("po") UserRoleRelCondition userRoleRelCondition);

    /**
     * @Description: 按条件获取用户角色关联表列表
     * @param page
     * @param userRoleRelCondition
     * @return
     */
    public List findUserRoleRelList(@Param("page") Page page, @Param("po") UserRoleRelCondition userRoleRelCondition);

    /**
     * @Description: 按条件获取用户角色关联表列表
     * @param userRoleRelCondition
     * @param userRoleRelCondition
     * @return
     */
    public List findUserRoleRelListByCondition(@Param("po") UserRoleRelCondition userRoleRelCondition);

	/**
	 * 插入用户角色关联表
	 * @param userRoleRel
	 */	 
	public void insertUserRoleRel(UserRoleRel userRoleRel);
	
	
    public void batchInsertUserRoleRel(@Param("userId") Long userId, @Param("ids") Long[] roleIds);
	/**
	 * 删除用户角色关联表
	 * @param userId
	 */
	public void deleteUserRoleRel(Long userId);
	
	/**
	 * 批量删除用户角色关联表
	 * @param ids
	 */
	public void deleteUserRoleRelBatch(@Param("ids") Long[] ids);


}
