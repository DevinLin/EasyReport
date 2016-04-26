package com.jd.coo.system.manager;


import com.jd.coo.common.Page;
import com.jd.coo.system.condition.UserDeptCondition;
import com.jd.coo.system.domain.UserDept;

/**
 * 用户系统表管理器
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-29 下午 06:03:12
 */
public interface UserDeptManager {


	/**
	 * 获取用户系统表列表
	 * @param page
	 * @return the UserDept
	 */
	public Page findUserDeptList(Page page, UserDeptCondition userDeptCondition);
	
	/**
	 * 插入用户系统表
	 * @param userDept
	 */
	public void insertUserDept(UserDept userDept);


	/**
	 * 删除用户系统表
	 * @param id
	 */
	public void deleteUserDept(Long id);

	public int findUserDeptCount(UserDept userDept);

	public void setAdmin(UserDeptCondition userDeptCondition);


}
