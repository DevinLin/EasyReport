package com.jd.coo.permission.dao;


import com.jd.coo.permission.condition.RoleResourceRelCondition;
import com.jd.coo.permission.domain.RoleResourceRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色资源关联Dao
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface RoleResourceRelDao {


	/**  
	* @Description: 按条件获取角色资源关联列表
	* @param roleResourceRelCondition
	* @return
	*/
	public List findRoleResourceRelList(@Param("po") RoleResourceRelCondition roleResourceRelCondition);
	
	/**
	 * 插入角色资源关联
	 * @param roleResourceRel
	 */	 
	public void insertRoleResourceRel(RoleResourceRel roleResourceRel);
	
	/**
	 * 更新角色资源关联
	 * @param roleResourceRel
	 */
	public void updateRoleResourceRel(RoleResourceRel roleResourceRel);
	
	/**
	 * 删除角色资源关联
	 * @param roleResourceRel
	 */
	public void deleteRoleResourceRel(RoleResourceRel roleResourceRel);
	
	/**
	 * 删除角色资源关联
	 */
	public void deleteRoleResourceRelByRoleId(Long roleId);


    public void  deleteRoleResourceRelByResourceId(Long resourceId);
	/**
	 * 批量删除角色资源关联
	 * @param ids
	 */
	public void deleteRoleResourceRelBatch(@Param("ids") Long[] ids);
}
