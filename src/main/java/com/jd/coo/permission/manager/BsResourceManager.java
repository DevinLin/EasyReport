package com.jd.coo.permission.manager;

import com.jd.coo.permission.condition.BsResourceCondition;
import com.jd.coo.permission.condition.UserCondition;
import com.jd.coo.permission.domain.BsResource;

import java.util.List;

/**
 * 资源管理器
 *
 * @author jianglongfei
 * @org logisticss.jd.com
 * @Date 2015-07-21 下午 03:19:35
 */
public interface BsResourceManager {

    /**
     * 获取资源
     *
     * @param id
     * @return the BsResource
     */
    public BsResource getBsResource(Long id);


    /**
     * 获取资源列表
     *
     * @return the BsResource
     */
    public List findBsResourceList(BsResourceCondition bsResourceCondition);

    /**
     * 插入资源
     *
     * @param bsResource
     */
    public void insertBsResource(BsResource bsResource);

    /**
     * 更新资源
     *
     * @param bsResource
     */
    public void updateBsResource(BsResource bsResource);

    /**
     * 删除资源
     *
     * @param id
     */
    public void deleteBsResource(Long id);

    /**
     * 批量删除资源
     *
     * @param ids
     */
    public void deleteBsResourceBatch(Long[] ids);


    public List findBsResourceListByParentId(Long parentId);

    public List findBsResourceListByCondition(UserCondition userCondition);

    public boolean findResourceByUserCodeAndResource(BsResourceCondition bsResourceCondition);

    public List<BsResource> findBsResourceListByRole(String roleCode);

}
