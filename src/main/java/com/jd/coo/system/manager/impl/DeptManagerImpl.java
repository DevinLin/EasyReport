package com.jd.coo.system.manager.impl;


import com.jd.coo.common.Page;
import com.jd.coo.system.condition.DeptCondition;
import com.jd.coo.system.dao.DeptDao;
import com.jd.coo.system.dao.UserDeptDao;
import com.jd.coo.system.domain.Dept;
import com.jd.coo.system.domain.UserDept;
import com.jd.coo.system.manager.DeptManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 系统表管理器实现
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
@Component
public class DeptManagerImpl implements DeptManager {

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(DeptManagerImpl.class);
	/**
	 * the DeptDao
	 */
	@Resource
	private DeptDao deptDao;
	
	@Resource
	private UserDeptDao userDeptDao;
	

	
	
	
	/*===============================================================================*/
	/*                                以下是增删改查方法
	/*===============================================================================*/
	/**
	 * 获取系统表
	 * @param id
	 * @return the Dept
	 */
	public Dept getDept(Long id) {
		Dept dept = deptDao.getDept(id);
		return dept;
	}

	
	public Page findDeptList(Page page, DeptCondition deptCondition) {
		page.setRows(deptDao.findDeptList(page, deptCondition));
		return page;
	}
	/**
	 * 插入系统表
	 * @param dept
	 */
   // @Transactional
	public void insertDept(Dept dept) {
	     Date date = new Date();
	     dept.setYn((byte)1);
		 dept.setCreateTime(date);
		 dept.setUpdateTime(date);
		deptDao.insertDept(dept);
		
		
		  UserDept userDept = new UserDept();
		  userDept.setYn((byte)1);
		  userDept.setAdmin((byte)1);
		  userDept.setCreateTime(date);
		  userDept.setUpdateTime(date);
		  userDept.setDeptCode(dept.getDeptCode());
		  userDept.setUserNo(dept.getUserNo());
		  userDept.setUserName(dept.getUserName());
		  userDeptDao.insertUserDept(userDept);

       
	}
	/**
	 * 更新系统表
	 * @param dept
	 */
	public void updateDept(Dept dept) {
	     dept.setUpdateTime(new Date());
		deptDao.updateDept(dept);

	}

	/**
	 * 删除系统表
	 * @param id
	 */
	public void deleteDept(Long id) {
		deptDao.deleteDept(id);
	}
	/**
	 * 批量删除系统表
	 */
	public void deleteDeptBatch(Long[] ids) {
		 deptDao.deleteDeptBatch(ids);
	}
	
	/*===============================================================================*/
	/*                                以下是get/set方法
	/*===============================================================================*/
	/**
	 * @return the deptDao
	 */
	public DeptDao getDeptDao() {
		return this.deptDao;
	}
	
	/**
	 * @param deptDao the deptDao to set
	 */
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public String findDeptAdmin(String deptCode) {
		return deptDao.findDeptAdmin(deptCode);
	}

	
}
