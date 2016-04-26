package com.jd.coo.system.service.impl;

import com.jd.coo.common.Page;
import com.jd.coo.system.condition.DeptCondition;
import com.jd.coo.system.domain.Dept;
import com.jd.coo.system.manager.DeptManager;
import com.jd.coo.system.service.DeptService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统表服务实现
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
@Component("deptService")
public class DeptServiceImpl implements DeptService {

	/**
	 * Logger for this class
	 */
	 private static final Logger log = Logger.getLogger(DeptServiceImpl.class);
	/**
	 * the DeptManager
	 */
	@Resource
	private DeptManager deptManager;

	/**
	 * 测试服务可用性的方法
	 * @param message
	 * @return
	 */
	public String echo(String message) {
		return "You said: " + message;
	}

	/* 
	 * (non-Javadoc)
	 * @see com.jd.logistics.base.portal.service.DeptService\#add(com.jd.logistics.base.portal.domain.Dept)
	 */
	public void insertDept(Dept dept) {
		deptManager.insertDept(dept);
	}

	/* 
	 * (non-Javadoc)
	 * @see com.jd.logistics.base.portal.service.DeptService\#update(com.jd.logistics.base.portal.domain.Dept)
	 */
	public void updateDept(Dept dept) {
		deptManager.updateDept(dept);
	}

	/* 
	 * (non-Javadoc)
	 * @seecom.jd.logistics.base.portal.service.DeptService\#delete(java.lang.Long)
	 */
	public void deleteDept(Long id) {
		deptManager.deleteDept(id);
	}
	/* 
	 * (non-Javadoc)
	 * @seecom.jd.logistics.base.portal.service.DeptService\#deleteBatch(java.lang.Long)
	 */
	public void deleteDeptBatch(Long[] ids)  {
		 deptManager.deleteDeptBatch(ids);
	}

	public Dept getDept(Long id) {
		return deptManager.getDept(id);
	}

	/* 
	 * (non-Javadoc)
	 * @see com.jd.logistics.base.portal.service.DeptService\#getDeptListPage(com.jd.logistics.domain.Dept, com.jd.logistics.common.Page)
	 */
	public Page findDeptList(Page page,DeptCondition deptCondition) {
		return deptManager.findDeptList(page, deptCondition);
	}

	public List findAllDeptList() {
		DeptCondition deptCondition = new DeptCondition();
		Page page = new Page();
		page.setPageSize(Integer.MAX_VALUE);
		page.setPage(1);
		return deptManager.findDeptList(page, deptCondition).getRows();
	}
	
	public List findDeptList(String userNo) {
		Page page = new Page();
		page.setPageSize(Integer.MAX_VALUE);
		DeptCondition deptCondition = new DeptCondition();
		deptCondition.setUserNo(userNo);
		return deptManager.findDeptList(page, deptCondition).getRows();
	}

	public String findDeptAdmin(String deptCode) {
		return deptManager.findDeptAdmin(deptCode);
	}

	
}
