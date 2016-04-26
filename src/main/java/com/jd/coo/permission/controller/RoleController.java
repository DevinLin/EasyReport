package com.jd.coo.permission.controller;

import com.jd.coo.common.Page;
import com.jd.coo.common.Result;
import com.jd.coo.permission.condition.RoleCondition;
import com.jd.coo.permission.condition.RoleResourceRelCondition;
import com.jd.coo.permission.domain.Role;
import com.jd.coo.permission.domain.RoleResourceRel;
import com.jd.coo.permission.manager.RoleManager;
import com.jd.coo.permission.manager.RoleResourceRelManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("role")
public class RoleController {
	
	@Resource
	private RoleManager roleManager;

	@Resource
	private RoleResourceRelManager roleResourceRelService;



    /**
     * 跳转到任务管理页面
     * @param model
     * @return
     * @date 2015-12-25 上午10:00:43
     */
    @RequestMapping(value = "/gotoRoleList.do", method = RequestMethod.GET)
    public String gotoRoleLis(Model model) {
        return "/permission/role/roleList";
    }
    /**
     * 查询任务
     */
    @RequestMapping(value = "/queryRoleList.do")
    public  @ResponseBody Object queryRoleList(Page page,RoleCondition roleCondition) {
        return roleManager.findRoleList(page, roleCondition);
    }

    /**
     * 跳转到任务管理页面
     * @param model
     * @return
     * @date 2015-12-25 上午10:00:43
     */
    @RequestMapping(value = "/gotoRoleEdit.do", method = RequestMethod.GET)
    public String gotoRoleEdit(Model model,Long id) {
    	if(id!=null){
    		Role role = roleManager.getRole(id);
    		model.addAttribute("role", role);
    	}
        return "/permission/role/roleEdit";
    }

	/**
     * 编辑任务
     */
    @RequestMapping(value = "/editRole.do")
    public  @ResponseBody Object editRole(Role role) {
    	if(role != null){
    		if(role.getId()!=null){
                roleManager.updateRole(role);
        	}else{
                roleManager.insertRole(role);
        	}
    	}

    	Result result = new Result(1,"操作成功!");
        return result;
    }

    /**
     * 删除任务
     */
    @RequestMapping(value = "/deleteRole.do")
    public  @ResponseBody Object deleteRole(String id) {
        roleManager.deleteRole(Long.parseLong(id));
    	Result result = new Result(1,"操作成功!");
        return result;
    }
    
    /**
     * 跳转到任务管理页面
     * @param model
     * @return
     * @date 2015-12-25 上午10:00:43
     */
    @RequestMapping(value = "/gotoRoleResourceList.do", method = RequestMethod.GET)
    public String gotoRoleResourceList(Model model,Long roleId) {
    	model.addAttribute("roleId", roleId);
        return "/permission/role/roleResourceList";
    }
    
    /**
     * 
     */
    @RequestMapping(value = "/queryRoleResourceList.do")
    public  @ResponseBody Object queryRoleResourceList(RoleResourceRelCondition roleResourceRelCondition) {
    	 List<RoleResourceRel> list = roleResourceRelService.findRoleResourceRelList(roleResourceRelCondition);
    	  List<RoleResourceRel> parentList = new ArrayList<RoleResourceRel>();
          for(RoleResourceRel bs:list){
         	 if(bs.getParentId()==null){
         		 parentList.add(bs);
         	 }
          }
          List<RoleResourceRel> allList = new ArrayList<RoleResourceRel>();
          for(RoleResourceRel parent:parentList){
         	 allList.add(parent);
         	 for(RoleResourceRel bs:list){
         		 if(bs.getParentId()!=null && parent.getId().intValue()==bs.getParentId().intValue()){
         			 allList.add(bs);
         			 for(RoleResourceRel bss:list){
         				 if(bss.getParentId()!=null && bs.getId().intValue()==bss.getParentId().intValue()){
         					 allList.add(bss);
         				 }
             		 }
         		 }
         	 }
          }
          Map map = new HashMap();
          map.put("rows",allList) ;
          return map;
    }
    /**
     * 编辑角色数据
     * @return
     */
    @RequestMapping(value = "/setRoleResource.do")
    public @ResponseBody  Object setRoleResource(HttpServletRequest request,boolean flag,RoleResourceRel roleResourceRel) {
        Result result = null;
            try {
                if(flag){
                    roleResourceRelService.insertRoleResourceRel(roleResourceRel);
                }else{
                    roleResourceRelService.deleteRoleResourceRel(roleResourceRel);
                }
                result = new Result(1,"操作成功!");
            } catch (Exception e) {
                result =  new Result(1,"操作失败!");
            }
        return result;
    }

}
