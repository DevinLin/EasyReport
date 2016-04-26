package com.jd.coo.main.controller;

import com.jd.common.web.LoginContext;
import com.jd.coo.permission.Icon;
import com.jd.coo.permission.SingleLoginUtil;
import com.jd.coo.permission.condition.UserCondition;
import com.jd.coo.permission.domain.BsResource;
import com.jd.coo.permission.manager.BsResourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linlingyue on 2016/4/15.
 */
@Controller
@RequestMapping("")
public class MainController {

    String DEFAULT_ROLE = "default_role";
    String SYSTEM_ROLE ="system";
//
//    @Resource
//    private SingleLoginUtil singleLoginUtil;

    @Autowired
    private BsResourceManager bsResourceManager ;


    @RequestMapping(value="/main.do" , method = RequestMethod.GET)
    public String main(Model model , HttpServletRequest request){

//        String userPin = LoginContext.getLoginContext().getPin();

        // TODO MainController 没有接入erp系统的登陆
        String userPin = "bjzjm";
        UserCondition uc = new UserCondition();
        uc.setUserCode(userPin);
        List<BsResource> resourceList = this.bsResourceManager.findBsResourceListByCondition(uc);

        if(resourceList.size() == 0 ){
            resourceList = this.bsResourceManager.findBsResourceListByRole(SYSTEM_ROLE);
//            resourceList = this.bsResourceManager.findBsResourceListByRole(DEFAULT_ROLE);
        }

        List<BsResource> parent = new ArrayList<BsResource>();

        for(BsResource br : resourceList){
            if(br.getParentId() == null ){
                parent.add(br);

                List<BsResource> childList = new ArrayList<BsResource>() ;
                for(BsResource child:resourceList){
                    if(child.getParentId() != null && br.getId().intValue() == child.getParentId().intValue()){
                        child.setClassName(Icon.getIcon(child.getCode()));
                        childList.add(child);
                    }
                }
                br.setChildren(childList);
            }
        }

        model.addAttribute("menus",parent);
        model.addAttribute("nick",userPin);

        return "main";
    }

    @RequestMapping(value = "/errorPage", method = RequestMethod.GET)
    public String errorPage(Model model, HttpServletResponse response) {
        return "error";
    }

    @RequestMapping("/logout.do")
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        singleLoginUtil.logout(response);
        return "success";
    }

    @RequestMapping(value = "/body.do", method = RequestMethod.GET)
    public String body(Model model, HttpServletResponse response) {
        return "body";
    }

}
