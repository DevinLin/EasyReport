package com.jd.coo.system.manager;

import com.jd.coo.common.Page;
import com.jd.coo.system.condition.TaskCondition;
import com.jd.coo.system.domain.Task;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by linlingyue on 2016/4/21.
 */
public interface TaskManager {

    /**
     * 获取当前周的工作内容
     * @return
     * @throws Exception
     */
    public Page getCurrentWorks(Page page,TaskCondition taskCondition) throws Exception;

    /**
     * 获取下周工作计划
     * @return
     * @throws Exception
     */
    public Page getNextWeekPlan(Page page,TaskCondition taskCondition) throws Exception;

    /**
     * 根据测试人员获取任务列表
     * @param testers   多个测试人员，入：林灵玥,纪晓辉
     * @return
     * @throws Exception
     */
    public Page getCurrentWorksByTester(Page page,String testers)throws Exception;

    /**
     * 根据测试人员获取任务列表
     * @param taskCondition   多个测试人员，入：林灵玥,纪晓辉
     * @return
     * @throws Exception
     */
    public Page getNextPlansByTester(Page page,TaskCondition taskCondition)throws Exception;

    /**
     * 根据上线时间查询任务列表
     * @param onlineStartTime
     * @param onlineEndTime
     * @return
     * @throws Exception
     */
    public Page getCurrentWorksByOnlineTime(Page page,String onlineStartTime,String onlineEndTime) throws Exception;

    /**
     * 根据上线时间查询下周计划列表
     * @param onlineStartTime
     * @param onlineEndTime
     * @return
     * @throws Exception
     */
    public Page getNextPlanByOnlineTime(Page page,String onlineStartTime,String onlineEndTime) throws Exception;

    /**
     * 获取历史任务记录
     * @param currentWeekNo
     * @return
     * @throws Exception
     */
    public Page getCurrentWorksHistory(Page page,int currentWeekNo) throws Exception;

    /**
     * 获取历史任务记录
     * @param currentWeekNo
     * @return
     * @throws Exception
     */
    public Page getNextPlansHistory(Page page,int currentWeekNo) throws Exception;

    /**
     * 提交任务
     * @param ids
     * @throws Exception
     */
    public void submitTask(Long[] ids)throws  Exception;

    /**
     * 插入任务
     * @param task
     * @throws Exception
     */
    public void insertTask(Task task) throws Exception ;

    /**
     * 获取任务列表
     * @param page
     * @param taskCondition
     * @return
     */
    public Page getTaskListByCondition(Page page,TaskCondition taskCondition) throws Exception;

}
