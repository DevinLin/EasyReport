package com.jd.coo.permission.manager;


import com.jd.coo.permission.condition.RoleResourceRelCondition;
import com.jd.coo.permission.domain.RoleResourceRel;

import java.util.List;

/**
 * 角色资源关联管理器
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface RoleResourceRelManager {


	
	/**
	 * 获取角色资源关联列表
	 * @param roleResourceRelCondition
	 * @return the RoleResourceRel
	 */
	public List findRoleResourceRelList(RoleResourceRelCondition roleResourceRelCondition);
	
	/**
	 * 插入角色资源关联
	 * @param roleResourceRel
	 */
	public void insertRoleResourceRel(RoleResourceRel roleResourceRel);

	/**
	 * 删除角色资源关联
	 * @param roleResourceRel
	 */
	public void deleteRoleResourceRel(RoleResourceRel roleResourceRel);


    public void   deleteRoleResourceRelByResourceId(Long resourceId);
	
	/**
	 * 批量删除角色资源关联
	 * @param id
	 */
	public void deleteRoleResourceRelBatch(Long[] ids);
}
