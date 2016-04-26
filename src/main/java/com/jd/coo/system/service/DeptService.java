package com.jd.coo.system.service;


import com.jd.coo.common.Page;
import com.jd.coo.system.condition.DeptCondition;
import com.jd.coo.system.domain.Dept;

import java.util.List;

/**
 * 系统表服务
 * @org logisticss.jd.com 
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface DeptService {
	
	/**
	 * 测试服务可用性的方法
	 * @param message
	 * @return
	 */
	public String echo(String message);
	
	/**  
	 * 添加系统表
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

	/**  
	 * 获取系统表
	 * @param id
	 * @return 
	 */
	public Dept getDept(Long id);
	
	/**  
	 * 查找系统表分页数据
	 * @param page
	 * @param deptCondition
	 * @return 
	 */
	public Page findDeptList(Page page, DeptCondition deptCondition);
	
	
	/**  
	 * 查找系统
	 * @param userNo
	 * @return 
	 */
	public List findDeptList(String userNo);
	
	

    /**
     * 查找系统表分页数据
     * @return
     */
    public List  findAllDeptList();
    
    public String findDeptAdmin(String deptCode);

	
	
}
