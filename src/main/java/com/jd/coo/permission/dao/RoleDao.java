package com.jd.coo.permission.dao;


import com.jd.coo.common.Page;
import com.jd.coo.permission.condition.RoleCondition;
import com.jd.coo.permission.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统表Dao
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface RoleDao {

	/**
	 * 获取系统表
	 * @param id
	 * @return the Role
	 */
	public Role getRole(Long id);

    /**
     * 获取角色表
     * @return the Role
     */
    public Role getRoleByCode(String roleCode);

	/**  
	* @Description: 按条件获取系统表列表
	* @param roleCondition
	* @return 
	*/
	public List findRoleList(@Param("page") Page page, @Param("po") RoleCondition roleCondition);

    /**
     * @Description: 按条件获取系统表列表
     * @param roleCondition
     * @return
     */
    public List findAllRoleList(@Param("po") RoleCondition roleCondition);

	/**
	 * 插入系统表
	 * @param role
	 */	 
	public void insertRole(Role role);
	
	/**
	 * 更新系统表
	 * @param role
	 */
	public void updateRole(Role role);
	
	/**
	 * 删除系统表
	 * @param id
	 */
	public void deleteRole(Long id);
	
	/**
	 * 批量删除系统表
	 */
	public void deleteRoleBatch(@Param("ids") Long[] ids);

}
