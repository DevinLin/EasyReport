package com.jd.coo.permission.manager.impl;


import com.jd.coo.permission.condition.BsResourceCondition;
import com.jd.coo.permission.condition.UserCondition;
import com.jd.coo.permission.dao.BsResourceDao;
import com.jd.coo.permission.dao.RoleResourceRelDao;
import com.jd.coo.permission.domain.BsResource;
import com.jd.coo.permission.manager.BsResourceManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 资源管理器实现
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
@Component("BsResourceManagerImpl")
public class  BsResourceManagerImpl implements BsResourceManager {

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(BsResourceManagerImpl.class);
	/**
	 * the BsResourceDao
	 */
	@Resource
	private BsResourceDao bsResourceDao;
	
	@Resource
	private RoleResourceRelDao roleResourceRelDao;
	
	
	
	/*===============================================================================*/
	/*                                以下是增删改查方法
	/*===============================================================================*/
	/**
	 * 获取资源
	 * @param id
	 * @return the BsResource
	 */
	public BsResource getBsResource(Long id) {
		BsResource bsResource = bsResourceDao.getBsResource(id);
		return bsResource;
	}

	
	public List findBsResourceList(BsResourceCondition bsResourceCondition) {
		 List<BsResource> list = bsResourceDao.findBsResourceList( bsResourceCondition);
		 for(BsResource r:list){
			 int count = bsResourceDao.findCountByParentId(r.getId());
			 if(count==0){
				 r.setLeaf(true);
				 r.setExpanded(false);
			 }
		 }
		 return list;
	}
	
	/**
	 * 插入资源
	 * @param bsResource
	 */
	public void insertBsResource(BsResource bsResource) {
	     Date date = new Date();
	     bsResource.setYn((byte)1);
		 bsResource.setCreateTime(date);
		 bsResource.setUpdateTime(date);
		bsResourceDao.insertBsResource(bsResource);
	}

	/**
	 * 更新资源
	 * @param bsResource
	 */
	public void updateBsResource(BsResource bsResource) {
	     bsResource.setUpdateTime(new Date());
		bsResourceDao.updateBsResource(bsResource);
	}

	/**
	 * 删除资源
	 * @param id
	 */
	public void deleteBsResource(Long id) {
		roleResourceRelDao.deleteRoleResourceRelByResourceId(id);
		bsResourceDao.deleteBsResource(id);
	}
	/**
	 * 批量删除资源
	 * @param ids
	 */
	public void deleteBsResourceBatch(Long[] ids) {
		 bsResourceDao.deleteBsResourceBatch(ids);
	}

    public List findBsResourceListByParentId(Long parentId) {
        return bsResourceDao.findBsResourceListByParentId(parentId);
    }

	public BsResourceDao getBsResourceDao() {
		return this.bsResourceDao;
	}
	
	/**
	 * @param bsResourceDao the bsResourceDao to set
	 */
	public void setBsResourceDao(BsResourceDao bsResourceDao) {
		this.bsResourceDao = bsResourceDao;
	}


	public List findBsResourceListByCondition(UserCondition userCondition) {
		return bsResourceDao.findBsResourceListByCondition(userCondition);
	}


	public boolean findResourceByUserCodeAndResource(
			BsResourceCondition bsResourceCondition) {
		int count = bsResourceDao.findResourceByUserCodeAndResource(bsResourceCondition);
		return count>0;
	}

	public List<BsResource> findBsResourceListByRole(String roleCode) {
		return bsResourceDao.findBsResourceListByRole(roleCode);
	}

	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-main.xml");
		BsResourceManager manager = (BsResourceManager)ac.getBean("BsResourceManagerImpl");
		BsResource br = new BsResource();
		br.setCode("bmgl");
		br.setParentId(Long.valueOf(246));
		br.setParentCode("ywgl");
		br.setName("部门管理");
		br.setType((byte)2);
		br.setUrl("/");
		br.setDescription("部门管理");

		manager.insertBsResource(br);
	}
}
