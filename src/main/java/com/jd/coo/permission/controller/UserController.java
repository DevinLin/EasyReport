package com.jd.coo.permission.controller;

import com.jd.coo.common.Page;
import com.jd.coo.common.Result;
import com.jd.coo.permission.condition.UserCondition;
import com.jd.coo.permission.condition.UserRoleRelCondition;
import com.jd.coo.permission.domain.User;
import com.jd.coo.permission.manager.UserManager;
import com.jd.coo.permission.manager.UserRoleRelManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("user")
public class UserController {
	
	@Resource
	private UserManager userService;
	
	@Resource
	private UserRoleRelManager userRoleRelService;
	
	
    /**
     * 跳转到任务管理页面
     * @param model
     * @return
     * @date 2015-12-25 上午10:00:43
     */
    @RequestMapping(value = "/gotoUserList.do", method = RequestMethod.GET)
    public String gotoUserLis(Model model) {
        return "/permission/user/userList";
    }
    /**
     * 查询任务
     */
    @RequestMapping(value = "/queryUserList.do")
    public  @ResponseBody Object queryUserList(Page page,UserCondition userCondition) {
        return userService.findUserList(page, userCondition);
    }

    /**
     * 跳转到任务管理页面
     * @param model
     * @return
     * @date 2015-12-25 上午10:00:43
     */
    @RequestMapping(value = "/gotoUserEdit.do", method = RequestMethod.GET)
    public String gotoUserEdit(Model model,Long id) {
    	if(id!=null){
    		User user = userService.getUser(id);
    		model.addAttribute("user", user);
    	}
        return "/permission/user/userEdit";
    }
    
	/**
     * 编辑任务
     */
    @RequestMapping(value = "/editUser.do")
    public  @ResponseBody Object editUser(User user) {
    	if(user != null){
    		if(user.getId()!=null){ 	
        		userService.updateUser(user);
        	}else{
        		userService.insertUser(user);
        	}
    	}
    	
    	Result result = new Result(1,"操作成功!");
        return result;
    }
    
    /**
     * 删除任务
     */
    @RequestMapping(value = "/deleteUser.do")
    public  @ResponseBody Object deleteUser(String id) {
    	userService.deleteUser(Long.parseLong(id));
    	Result result = new Result(1,"操作成功!");
        return result;
    }
    /**
     * 跳转到任务管理页面
     * @param model
     * @return
     * @date 2015-12-25 上午10:00:43
     */
    @RequestMapping(value = "/gotoUserRoleList.do", method = RequestMethod.GET)
    public String gotoUserResourceList(Model model,Long userId) {
    	model.addAttribute("userId", userId);
        return "/permission/user/userRoleList";
    }
    /**
     * 查询任务
     */
    @RequestMapping(value = "/queryUserRoleList.do")
    public  @ResponseBody Object queryUserRoleList(Page page,UserRoleRelCondition userRoleRelCondition) {
        return userRoleRelService.findUserRoleRelList(page, userRoleRelCondition);
    }
    /**
     * 删除用户数据
     * @return
     */
    @RequestMapping(value = "/setUserRole.do")
    public @ResponseBody  Object setUserRole(HttpServletRequest request,String userId,Long[] roleIds) {
        Result result = null;
        System.out.println(userId);
        try {
            userRoleRelService.batchInsertUserRoleRel(Long.parseLong(userId),roleIds);
            result = new Result(1,"");
        } catch (Exception e) {
            result =  new Result(1,"");
        }
        return result;
    }
    
    
}
