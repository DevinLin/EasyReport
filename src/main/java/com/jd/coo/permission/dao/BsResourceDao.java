package com.jd.coo.permission.dao;


import com.jd.coo.permission.condition.BsResourceCondition;
import com.jd.coo.permission.condition.UserCondition;
import com.jd.coo.permission.domain.BsResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资源Dao
 * @org logisticss.jd.com
 * @author jianglongfei
 * @Date 2015-07-21 下午 03:19:35
 */
public interface BsResourceDao {

	/**
	 * 获取资源
	 * @param id
	 * @return the BsResource
	 */
	public BsResource getBsResource(Long id);

	/**  
	* @Description: 按条件获取资源列表
	* @param bsResourceCondition
	* @return 
	*/
	public List findBsResourceList(@Param("po") BsResourceCondition bsResourceCondition);
	
	/**
	 * 插入资源
	 * @param bsResource
	 */	 
	public void insertBsResource(BsResource bsResource);
	
	/**
	 * 更新资源
	 * @param bsResource
	 */
	public void updateBsResource(BsResource bsResource);
	
	/**
	 * 删除资源
	 * @param id
	 */
	public void deleteBsResource(Long id);
	
	/**
	 * 批量删除资源
	 * @param ids
	 */
	public void deleteBsResourceBatch(@Param("ids") Long[] ids);

    public List findBsResourceListByParentId(@Param("parentId") Long parentId);
    
    
    public int findCountByParentId(@Param("parentId") Long parentId);
    
    public List findBsResourceListByCondition(UserCondition userCondition);

	public int findResourceByUserCodeAndResource(@Param("po")
												 BsResourceCondition bsResourceCondition);

	public List<BsResource> findBsResourceListByRole(@Param("roleCode") String roleCode);

}
