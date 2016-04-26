package com.jd.coo.system.controller;

import com.jd.coo.common.Page;
import com.jd.coo.common.Result;
import com.jd.coo.permission.condition.UserCondition;
import com.jd.coo.system.condition.TaskCondition;
import com.jd.coo.system.domain.Task;
import com.jd.coo.system.manager.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linlingyue on 2016/4/22.
 */
@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskManager taskManager ;

    @RequestMapping("/gotoEmployeeList.do")
    public String gotoEmployeeList(){
        return "/system/task/employeeList";
    }

    @RequestMapping("/gotoManagerList.do")
    public String gotoManagerList()
    {
        return "/system/task/managerList";
    }

    @RequestMapping("/gotoTaskAdd.do")
    public String gotoTaskAdd()
    {
        return "/system/task/addTask";
    }


    @RequestMapping(value="/queryTaskList.do" , method = RequestMethod.GET)
    public @ResponseBody Object queryTaskList(Page page,TaskCondition tc){

        Page rst=null ;
        try {
            rst = this.taskManager.getTaskListByCondition(page, tc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rst ;
    }


    @RequestMapping(value="/addTask.do",method = RequestMethod.GET)
    public @ResponseBody Object insertTask(Task tc){
        Result rst = null ;

        try {
            this.taskManager.insertTask(tc);
            rst = new Result(1,"添加成功");

        } catch (Exception e) {
            rst = new Result(0,"添加失败");
            e.printStackTrace();
        }
        return rst;
    }

}
