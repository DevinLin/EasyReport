package com.jd.coo.permission.manager;


import com.jd.coo.common.Page;
import com.jd.coo.permission.condition.RoleCondition;
import com.jd.coo.permission.domain.Role;

/**
 * 角色表管理器
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface RoleManager {

	/**
	 * 获取角色表
	 * @param id
	 * @return the Role
	 */
	public Role getRole(Long id);

	
	/**
	 * 获取角色表列表
	 * @param id
	 * @return the Role
	 */
	public Page findRoleList(Page page, RoleCondition roleCondition);

	/**
	 * 插入角色表
	 * @param role
	 */
	public void insertRole(Role role);

	/**
	 * 更新角色表
	 * @param role
	 */
	public void updateRole(Role role);

	/**
	 * 删除角色表
	 * @param id
	 */
	public void deleteRole(Long id);
	
	/**
	 * 批量删除角色表
	 * @param id
	 */
	public void deleteRoleBatch(Long[] ids);

}
