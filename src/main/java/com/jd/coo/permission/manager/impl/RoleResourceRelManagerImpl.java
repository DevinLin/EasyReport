package com.jd.coo.permission.manager.impl;


import com.jd.coo.permission.condition.RoleResourceRelCondition;
import com.jd.coo.permission.dao.BsResourceDao;
import com.jd.coo.permission.dao.RoleResourceRelDao;
import com.jd.coo.permission.domain.RoleResourceRel;
import com.jd.coo.permission.manager.RoleResourceRelManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 角色资源关联管理器实现
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
@Component
public class RoleResourceRelManagerImpl implements RoleResourceRelManager {

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(RoleResourceRelManagerImpl.class);
	/**
	 * the RoleResourceRelDao
	 */
	@Resource
	private RoleResourceRelDao roleResourceRelDao;
	
	@Resource
	private BsResourceDao bsResourceDao;
	
	
	public List findRoleResourceRelList(RoleResourceRelCondition roleResourceRelCondition) {
		List<RoleResourceRel> list =  roleResourceRelDao.findRoleResourceRelList( roleResourceRelCondition);
		 for(RoleResourceRel r:list){
			 int count = bsResourceDao.findCountByParentId(r.getId());
			 if(count==0){
				 r.setLeaf(true);
				 r.setExpanded(false);
			 }
		 }
		 return list;
		
	}
	
	/**
	 * 插入角色资源关联
	 * @param roleResourceRel
	 */
	public void insertRoleResourceRel(RoleResourceRel roleResourceRel) {
	     Date date = new Date();
	     roleResourceRel.setYn((byte)1);
		 roleResourceRel.setCreateTime(date);
		 roleResourceRel.setUpdateTime(date);
		roleResourceRelDao.insertRoleResourceRel(roleResourceRel);
	}
	/**
	 * 删除角色资源关联
	 * @param roleResourceRel
	 */
	public void deleteRoleResourceRel(RoleResourceRel roleResourceRel) {
		roleResourceRelDao.deleteRoleResourceRel(roleResourceRel);
	}

    public void deleteRoleResourceRelByResourceId(Long resourceId) {
        roleResourceRelDao.deleteRoleResourceRelByResourceId(resourceId);
    }

    /**
	 * 批量删除角色资源关联
	 * @param ids
	 */
	public void deleteRoleResourceRelBatch(Long[] ids) {
		 roleResourceRelDao.deleteRoleResourceRelBatch(ids);
	}
	
	/*===============================================================================*/
	/*                                以下是get/set方法
	/*===============================================================================*/
	/**
	 * @return the roleResourceRelDao
	 */
	public RoleResourceRelDao getRoleResourceRelDao() {
		return this.roleResourceRelDao;
	}
	
	/**
	 * @param roleResourceRelDao the roleResourceRelDao to set
	 */
	public void setRoleResourceRelDao(RoleResourceRelDao roleResourceRelDao) {
		this.roleResourceRelDao = roleResourceRelDao;
	}
	
}
