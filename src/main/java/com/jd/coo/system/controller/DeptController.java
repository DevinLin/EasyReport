package com.jd.coo.system.controller;

import com.jd.common.web.LoginContext;
import com.jd.coo.common.Page;
import com.jd.coo.common.Result;
import com.jd.coo.system.condition.DeptCondition;
import com.jd.coo.system.condition.UserDeptCondition;
import com.jd.coo.system.domain.Dept;
import com.jd.coo.system.manager.DeptManager;
import com.jd.coo.system.service.DeptService;
import com.jd.coo.system.service.UserDeptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("dept")
public class DeptController {
	
//	@Resource
//	private HrUserService hrUserService;
//
//	@Resource
//	private  HrUserCfgBean hrUserCfgBean;
	
	
	@Resource
	private UserDeptService userDeptService;
	
	@Resource
	private DeptService deptService;
	
	
	
    /**
     * 跳转到任务管理页面
     * @param model
     * @return
     * @date 2015-12-25 上午10:00:43
     */
    @RequestMapping(value = "/gotoDeptList.do", method = RequestMethod.GET)
    public String gotoDeptLis(Model model) {
        return "/system/dept/deptList";
    }
    /**
     * 查询任务
     */
    @RequestMapping(value = "/queryDeptList.do")
    public  @ResponseBody Object queryDeptList(Page page,DeptCondition deptCondition) {
    	deptCondition.setUserNo(LoginContext.getLoginContext().getPin());
        return deptService.findDeptList(page, deptCondition);
    }

    /**
     * 跳转到任务管理页面
     * @param model
     * @return
     * @date 2015-12-25 上午10:00:43
     */
    @RequestMapping(value = "/gotoDeptEdit.do", method = RequestMethod.GET)
    public String gotoDeptEdit(Model model,Long id) {
    	if(id!=null){
    		Dept dept = deptService.getDept(id);
    		model.addAttribute("dept", dept);
    	}
        return "/system/dept/deptEdit";
    }
    
	/**
     * 编辑任务
     */
    @RequestMapping(value = "/editDept.do")
    public  @ResponseBody Object editDept(Dept dept) {
    	if(dept != null){
    		if(dept.getId()!=null){ 	
        		deptService.updateDept(dept);
        	}else{
        		LoginContext loginContext = LoginContext.getLoginContext();
        		dept.setUserNo(loginContext.getPin());
        		dept.setUserName(loginContext.getNick());
        		deptService.insertDept(dept);
        	}
    	}
    	
    	Result result = new Result(1,"操作成功!");
        return result;
    }
    
    /**
     * 删除任务
     */
    @RequestMapping(value = "/deleteDept.do")
    public  @ResponseBody Object deleteDept(String id) {
    	deptService.deleteDept(Long.parseLong(id));
    	Result result = new Result(1,"操作成功!");
        return result;
    }
    
    /**
     * 跳转到用户授权页面
     * @param model
     * @return
     * @date 2015-12-25 上午10:00:43
     */
    @RequestMapping(value = "/gotoUserList.do", method = RequestMethod.GET)
    public String gotoUserList(Model model,String deptCode) {
    	String userNo = deptService.findDeptAdmin(deptCode);
    	model.addAttribute("admin",userNo.equals(LoginContext.getLoginContext().getPin()));
    	model.addAttribute("deptCode",deptCode);
        return "/system/dept/userList";
    }
    
    /**
     * 编辑任务
     * @throws Exception 
     */
//    @RequestMapping(value = "/findUserByErp.do")
//    public  @ResponseBody Object findUserByErp(String erp,String deptCode) throws Exception {
//    	   ErpUser user = null;
//    	   String sign = null;
//           String appCode = hrUserCfgBean.getAppCode();
//           String businessId = hrUserCfgBean.getBusinessId();
//           String requestTimestamp = DateUtil.format(new Date(), DateUtil.FORMAT_DATE_TIME);
//           String safetyKey = hrUserCfgBean.getSafetyKey();
//           MD5Util util = new MD5Util();
//           sign = util.getSign(appCode, businessId, requestTimestamp, safetyKey, erp);
//           String response = hrUserService.getUserBaseInfoByUserName(appCode, businessId, requestTimestamp, sign, null, erp);
//           String res = URLDecoder.decode(response, "UTF-8");
//           Map<String,Object> result = new HashMap<String,Object>();
//          if (response != null) {
//              ErpUserInfo eum = JsonUtils.parseObject(res, ErpUserInfo.class);
//              String code = eum.getResStatus();
//              if ("200".equals(code)) {
//                   user = eum.getResponsebody();
//              } else {
//                  //log.error("状态：" + code + ", 调用omdm接口根据erp获取信息异常。");
//              }
//          } else {
//              //log.error("调用omdm接口根据erp获取信息异常, 返回资源信息：" + response);
//          }
//
//          if(user.getUserCode()==null){
//        	  result.put("code", 0);
//        	  result.put("msg", "当前帐号不存在!");
//          }else{
//        	  //判断当前的系统中该帐号是否存在
//        	  UserDept userDept = new UserDept();
//        	  userDept.setUserNo(user.getUserName());
//        	  userDept.setUserName(user.getRealName());
//        	  userDept.setEmail(user.getEmail());
//        	  userDept.setTel(user.getTelephone());
//        	  userDept.setDeptCode(deptCode);
//        	  int count = userDeptService.findUserDeptCount(userDept);
//        	  if(count>0){
//        		  result.put("code", -1);
//        		  result.put("msg", "当前帐号已经存在!");
//        	  }else{
//        		  userDeptService.insertUserDept(userDept);
//        		  result.put("code", 1);
//        		  result.put("msg", "操作成功!");
//        	  }
//          }
//          return result;
//    }
    	
    /**
     * 查询任务
     */
    @RequestMapping(value = "/queryUserDeptList.do")
    public  @ResponseBody Object queryUserDeptList(Page page,UserDeptCondition userDeptCondition) {
    	return this.userDeptService.findUserDeptList(page, userDeptCondition);
    	
    }
    
    /**
     * 删除任务
     */
    @RequestMapping(value = "/setAdmin.do")
    public  @ResponseBody Object setAdmin(UserDeptCondition userDeptCondition) {
    	userDeptService.setAdmin(userDeptCondition);
    	Result result = new Result(1,"操作成功!");
        return result;
    }

    /**
     * 删除任务
     */
    @RequestMapping(value = "/deleteUserDept.do")
    public  @ResponseBody Object deleteUserDept(String id) {
    	userDeptService.deleteUserDept(Long.parseLong(id));
    	Result result = new Result(1,"操作成功!");
        return result;
    }
    
    
}
