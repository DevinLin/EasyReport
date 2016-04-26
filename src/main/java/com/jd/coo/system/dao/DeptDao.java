package com.jd.coo.system.dao;

import com.jd.coo.common.Page;
import com.jd.coo.system.condition.DeptCondition;
import com.jd.coo.system.domain.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统表Dao
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface DeptDao {

	/**
	 * 获取系统表
	 * @param id
	 * @return the Dept
	 */
	public Dept getDept(Long id);

    /**
     * 获取系统表
     * @return the Dept
     */
    public Dept getDeptByCode(String deptCode);

	/**  
	* @Description: 按条件获取系统表列表
	* @param deptCondition
	* @return 
	*/
	public List findDeptList(@Param("page") Page page, @Param("po") DeptCondition deptCondition);

    /**
     * @Description: 按条件获取系统表列表
     * @param deptCondition
     * @return
     */
    public List findAllDeptList(@Param("po") DeptCondition deptCondition);


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
	 */
	public void deleteDeptBatch(@Param("ids") Long[] ids);

	public String findDeptAdmin(String deptCode);
}
