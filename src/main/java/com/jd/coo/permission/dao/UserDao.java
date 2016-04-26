package com.jd.coo.permission.dao;


import com.jd.coo.common.Page;
import com.jd.coo.permission.condition.UserCondition;
import com.jd.coo.permission.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统表Dao
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface UserDao {

	/**
	 * 获取系统表
	 * @param id
	 * @return the User
	 */
	public User getUser(Long id);

    /**
     * 获取角色表
     * @return the User
     */
    public User getUserByCode(String userCode);

	/**  
	* @Description: 按条件获取系统表列表
	* @param userCondition
	* @return 
	*/
	public List findUserList(@Param("page") Page page, @Param("po") UserCondition userCondition);

    /**
     * @Description: 按条件获取系统表列表
     * @param userCondition
     * @return
     */
    public List findAllUserList(@Param("po") UserCondition userCondition);

	/**
	 * 插入系统表
	 * @param user
	 */	 
	public void insertUser(User user);
	
	/**
	 * 更新系统表
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 删除系统表
	 * @param id
	 */
	public void deleteUser(Long id);
	
	/**
	 * 批量删除系统表
	 */
	public void deleteUserBatch(@Param("ids") Long[] ids);

}
