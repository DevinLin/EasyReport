package com.jd.coo.system.manager;


import com.jd.coo.common.Page;
import com.jd.coo.system.condition.DeptCondition;
import com.jd.coo.system.domain.Dept;

/**
 * 系统表管理器
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface DeptManager {

	/**
	 * 获取系统表
	 * @param id
	 * @return the Dept
	 */
	public Dept getDept(Long id);

	
	/**
	 * 获取系统表列表
	 * @param id
	 * @return the Dept
	 */
	public Page findDeptList(Page page, DeptCondition deptCondition);

	/**
	 * 插入系统表
	 * @param dept
	 */
	public void insertDept(Dept dept);

	/**
	 * 更新系统表
	 * @param dept
	 */
	public void updateDept(Dept dept);

	/**
	 * 删除系统表
	 * @param id
	 */
	public void deleteDept(Long id);
	
	/**
	 * 批量删除系统表
	 * @param id
	 */
	public void deleteDeptBatch(Long[] ids);


	public String findDeptAdmin(String deptCode);


}
