package com.jd.coo.system.dao;

import com.jd.coo.common.Page;
import com.jd.coo.system.condition.UserDeptCondition;
import com.jd.coo.system.domain.UserDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户系统表Dao
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-29 下午 06:03:12
 */
public interface UserDeptDao {

	/**
	 * 获取用户系统表
	 * @param id
	 * @return the UserDept
	 */
	public UserDept getUserDept(Long id);

    public List    getUserDeptByUserNo(String userNo);

    public List getUserDeptNoRfByUserNo(String userNo);
	/**
	* @Description: 按条件获取用户系统表列表
	* @param page
	* @param page
	* @return 
	*/
	public List findUserDeptList(@Param("page") Page page, @Param("po") UserDeptCondition userDeptCondition);
	
	/**
	 * 插入用户系统表
	 * @param userDept
	 */	 
	public void insertUserDept(UserDept userDept);
	
	
	public void  updateAdminUserDeptByDeptCode(String deptCode);
	
	/**
	 * 更新用户系统表
	 * @param userDept
	 */
	public void updateUserDept(UserDept userDept);

	/**
	 * 删除用户系统表
	 * @param id
	 */
	public void deleteUserDept(Long id);

	/**
	 * 批量删除用户系统表
	 */
	public void deleteUserDeptBatch(@Param("ids") Long[] ids);


    public void deleteUserDeptByUserNo(String userNo);

	public int findUserDeptCount(UserDept userDept);


}
