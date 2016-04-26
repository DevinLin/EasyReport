package com.jd.coo.system.service;

import com.jd.coo.common.Page;
import com.jd.coo.system.condition.TaskCondition;
import com.jd.coo.system.domain.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by linlingyue on 2016/4/21.
 */
public interface TaskService {

    /**
     * 获取任务信息
     * @param id
     * @return
     */
    public Task getTaskById(Long id) throws Exception;

    /**
     * 根据上线时间获取任务列表
     * @return
     * @throws Exception
     */
    public List<Task> getTasksByOnlineTime(Page page,String online_startTime,String online_endTime) throws  Exception;

    /**
     * 根据条件获取任务列表
     * @param taskCondition
     * @return
     * @throws Exception
     */
    public List<Task> getTasksByCondition(Page page,TaskCondition taskCondition) throws Exception ;

    /**
     * 更新任务
     * @param task
     * @throws Exception
     */
    public void updateTask(Task task) throws Exception;

    /**
     * 删除任务
     * @param id
     * @throws Exception
     */
    public void deleteTask(Long id ) throws Exception ;

    /**
     * 新增任务
     * @param task
     * @throws Exception
     */
    public void insertTask(Task task) throws  Exception ;


    /**
     * 批量删除任务
     * @param ids
     * @throws Exception
     */
    public void deleteTasks(Long[] ids) throws Exception ;


}
