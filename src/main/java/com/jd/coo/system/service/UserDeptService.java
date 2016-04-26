package com.jd.coo.system.service;


import com.jd.coo.common.Page;
import com.jd.coo.system.condition.UserDeptCondition;
import com.jd.coo.system.domain.UserDept;

/**
 * 用户系统表服务
 * @org logisticss.jd.com 
 * @author jianglongfei
 * @Date 2015-07-29 下午 06:03:12
 */
public interface UserDeptService {


	/**
	 * 添加用户系统表
	 * @param userDept
	 */
	public void insertUserDept(UserDept userDept);
	

	/**
	 * 删除用户系统表
	 * @param id
	 */
	public void deleteUserDept(Long id);

	/**
	 * 查找用户系统表分页数据
	 * @param page
	 * @param userDeptCondition
	 * @return 
	 */
	public Page findUserDeptList(Page page, UserDeptCondition userDeptCondition);


	public int findUserDeptCount(UserDept userDept);
	
	public void setAdmin(UserDeptCondition userDeptCondition);

}
