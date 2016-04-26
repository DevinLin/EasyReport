package com.jd.coo.system.service.impl;

import com.jd.coo.common.Page;
import com.jd.coo.system.condition.TaskCondition;
import com.jd.coo.system.dao.TaskDao;
import com.jd.coo.system.domain.Task;
import com.jd.coo.system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by linlingyue on 2016/4/21.
 */
@Component("TaskServiceImpl")
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao ;

    public Task getTaskById(Long id) throws Exception {
        return this.taskDao.getTaskById(id);
    }

    public List<Task> getTasksByOnlineTime(Page page,String online_startTime, String online_endTime) throws Exception {
        TaskCondition tc = new TaskCondition();
        tc.setOnline_startTime(online_startTime);
        tc.setOnline_endTime(online_endTime);
        return this.taskDao.getTasksByCondition(page, tc);
    }

    public List<Task> getTasksByCondition(Page page, TaskCondition taskCondition) throws Exception {
        return this.taskDao.getTasksByCondition(page,taskCondition);
    }

    public void updateTask(Task task) throws Exception {
        this.taskDao.updateTask(task);

    }

    public void deleteTask(Long id) throws Exception {
        this.taskDao.deleteTask(id);
    }

    public void insertTask(Task task) throws Exception {
        this.taskDao.insertTask(task);
    }

    public void deleteTasks(Long[] ids) throws Exception {
        this.taskDao.deleteTasks(ids);
    }

    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-main.xml");
        TaskService ts = (TaskService)ac.getBean("TaskServiceImpl");


        try {
            for( int i = 10 ;i <30 ;i++) {
                Task t = new Task();
                t.setCategory("p");
                t.setCreate_time(new Date());
                t.setCreate_user("linlingyue");
                t.setCurrentSchedule(50);
                t.setExpectedSchedule(100);
                t.setLastWeekSchedule(100);
                t.setOnline_time(new Date());
                t.setProductMgr("zhouyue");
                t.setProject_name("Indonesia");
                t.setReason("completed");
                t.setRisk("Risk");
                t.setSummary("pop订单联调+" + i);
                t.setTask_type(3);
                t.setTester("Devin");


                Calendar c=Calendar.getInstance();
                t.setWeekNo(c.get(Calendar.WEEK_OF_YEAR));
                t.setTesting_endtime(new Date());
                t.setTesting_starttime(new Date());
                ts.insertTask(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
