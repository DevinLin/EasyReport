package com.jd.coo.permission.manager.impl;


import com.jd.coo.common.Page;
import com.jd.coo.permission.condition.RoleCondition;
import com.jd.coo.permission.dao.RoleDao;
import com.jd.coo.permission.dao.RoleResourceRelDao;
import com.jd.coo.permission.domain.Role;
import com.jd.coo.permission.manager.RoleManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 角色表管理器实现
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
@Component("RoleManagerImpl")
public class RoleManagerImpl implements RoleManager {

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(RoleManagerImpl.class);
	/**
	 * the RoleDao
	 */
	@Resource
	private RoleDao roleDao;
	
	@Resource
	private RoleResourceRelDao roleResourceRelDao;
	
	
	/*===============================================================================*/
	/*                                以下是增删改查方法
	/*===============================================================================*/
	/**
	 * 获取角色表
	 * @param id
	 * @return the Role
	 */
	public Role getRole(Long id) {
		Role role = roleDao.getRole(id);
		return role;
	}

	
	public Page findRoleList(Page page, RoleCondition roleCondition) {
		page.setRows(roleDao.findRoleList(page, roleCondition));
		return page;
	}
	/**
	 * 插入角色表
	 * @param role
	 */
   // @Transactional
	public void insertRole(Role role) {
	     Date date = new Date();
	     role.setYn((byte)1);
		 role.setCreateTime(date);
		 role.setUpdateTime(date);
		roleDao.insertRole(role);
       
	}
	/**
	 * 更新角色表
	 * @param role
	 */
	public void updateRole(Role role) {
	     role.setUpdateTime(new Date());
		roleDao.updateRole(role);

	}

	/**
	 * 删除角色表
	 * @param id
	 */
	public void deleteRole(Long id) {
		roleResourceRelDao.deleteRoleResourceRelByRoleId(id);
		roleDao.deleteRole(id);
	}
	/**
	 * 批量删除角色表
	 */
	public void deleteRoleBatch(Long[] ids) {
		 roleDao.deleteRoleBatch(ids);
	}
	
	/*===============================================================================*/
	/*                                以下是get/set方法
	/*===============================================================================*/
	/**
	 * @return the roleDao
	 */
	public RoleDao getRoleDao() {
		return this.roleDao;
	}
	
	/**
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}



	
}
