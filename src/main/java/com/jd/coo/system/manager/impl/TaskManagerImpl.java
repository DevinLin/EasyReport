package com.jd.coo.system.manager.impl;

import com.jd.common.util.StringUtils;
import com.jd.coo.common.CategoryEnum;
import com.jd.coo.common.DateUtils;
import com.jd.coo.common.Page;
import com.jd.coo.system.condition.TaskCondition;
import com.jd.coo.system.dao.TaskDao;
import com.jd.coo.system.domain.Task;
import com.jd.coo.system.manager.TaskManager;
import com.jd.coo.system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by linlingyue on 2016/4/22.
 */
@Component
public class TaskManagerImpl implements TaskManager {

    @Autowired
    private TaskService taskService;


    /**
     * 如果是普通员工，查看是查看当前周的，领导可能就是看上周的
     *
     * @param page
     * @param taskCondition
     * @return
     * @throws Exception
     */
    public Page getCurrentWorks(Page page, TaskCondition taskCondition) throws Exception {

        taskCondition.setCategory(CategoryEnum.CURRENT.getValue());
        List<Task> taskList = this.taskService.getTasksByCondition(page, taskCondition);
        page.setRows(taskList);
        return page;
    }

    public Page getNextWeekPlan(Page page, TaskCondition taskCondition) throws Exception {
        taskCondition.setCategory(CategoryEnum.NEXTPLAN.getValue());
        List<Task> taskList = this.taskService.getTasksByCondition(page, taskCondition);
        page.setRows(taskList);
        return page;
    }

    public Page getCurrentWorksByTester(Page page, String testers) throws Exception {
        TaskCondition tc = new TaskCondition();
        tc.setCategory(CategoryEnum.CURRENT.getValue());
        tc.setTester(testers);
        this.taskService.getTasksByCondition(page,tc);
        return null;
    }

    public Page getNextPlansByTester(Page page, TaskCondition tc) throws Exception {

        tc.setCategory(CategoryEnum.NEXTPLAN.getValue());
        this.taskService.getTasksByCondition(page,tc);
        return null;
    }

    public Page getCurrentWorksByOnlineTime(Page page, String onlineStartTime, String onlineEndTime) throws Exception {
        return null;
    }

    public Page getNextPlanByOnlineTime(Page page, String onlineStartTime, String onlineEndTime) throws Exception {
        return null;
    }

    public Page getCurrentWorksHistory(Page page, int currentWeekNo) throws Exception {
        return null;
    }

    public Page getNextPlansHistory(Page page, int currentWeekNo) throws Exception {
        return null;
    }

    public void submitTask(Long[] ids) throws Exception {

        for(Long id : ids){
            Task t = new Task();
            t.setId(id);
            t.setStatus(1);
            this.taskService.updateTask(t);
        }

    }

    public void insertTask(Task task) throws Exception {
        this.taskService.insertTask(task);
    }

    public Page getTaskListByCondition(Page page, TaskCondition taskCondition)  throws Exception{

        List<Task> tasksByCondition = this.taskService.getTasksByCondition(page, taskCondition);
        page.setRows(tasksByCondition);
        return page;
    }
}
