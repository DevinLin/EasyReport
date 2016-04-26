package com.jd.coo.permission.controller;

import com.jd.coo.common.Result;
import com.jd.coo.permission.condition.BsResourceCondition;
import com.jd.coo.permission.domain.BsResource;
import com.jd.coo.permission.manager.BsResourceManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BsResource控制器
 * @author jianglongfei
 * @date 2015-07-21  03:19:35
 */
@Controller
@RequestMapping("bsResource")
public class BsResourceController {
	
	@Resource
	BsResourceManager bsResourceService;
    /**
     * 
     */
    private static final Logger logger = Logger.getLogger(BsResourceController.class);

    /**
     * 跳转到资源管理主页面
     * @return
     */
    @RequestMapping(value = "/gotoBsResourcePage.do",method = {RequestMethod.GET, RequestMethod.POST})
    public String gotoBsResourcePage(Model model,BsResourceCondition bsResourceCondition) {
    	return "/permission/bsResource/bsResourceList";
    }
    /**
     * 查询资源列表数据
     */
    @RequestMapping(value = "/queryBsResourceList.do")
    public @ResponseBody  Object queryBsResourceList(BsResourceCondition bsResourceCondition,HttpServletRequest request) {
    	
         List<BsResource> list = bsResourceService.findBsResourceList(bsResourceCondition);
         
         List<BsResource> parentList = new ArrayList<BsResource>();
         for(BsResource bs:list){
        	 if(bs.getParentId()==null){
        		 parentList.add(bs);
        	 }
         }
         List<BsResource> allList = new ArrayList<BsResource>();
         for(BsResource parent:parentList){
        	 allList.add(parent);
        	 for(BsResource bs:list){
        		 if(bs.getParentId()!=null && parent.getId().intValue()==bs.getParentId().intValue()){
        			 allList.add(bs);
        			 for(BsResource bss:list){
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
     * 跳转到资源页面
     * @return
     */
    @RequestMapping(value = "/gotoBsResourceEdit.do")
    public String  gotoBsResourceEdit(Long id,Model model) {
    	if(id != null){
    		BsResource bsResource = bsResourceService.getBsResource(id);
        	model.addAttribute("bsResource", bsResource);
    	}
    	return "/permission/bsResource/bsResourceEdit";
    }


    /**
     * 添加子菜单
     * @return
     */
    @RequestMapping(value = "/gotoBsResourceAdd.do")
    public String  gotoBsResourceAdd(Long id,Model model) {
        if(id != null){
            BsResource parent = bsResourceService.getBsResource(id);
            model.addAttribute("parent", parent);
        }
        return "/permission/bsResource/bsResourceAdd";
    }
	
	
    /**
     * 编辑资源数据
     * @return
     */
    @RequestMapping(value = "/editBsResource.do")
    public @ResponseBody  Object editBsResource(HttpServletRequest request,@Valid @ModelAttribute BsResource bsResource,Errors errors) {
		Result result = null;
    	if(bsResource != null){
			try {
				if(bsResource.getId() == null){
                    int type =  bsResource.getType()+1;
                    bsResource.setType((byte)type);
					bsResourceService.insertBsResource(bsResource);
				}else{
					bsResourceService.updateBsResource(bsResource);
				}
				result = new Result(1,"操作成功");
			} catch (Exception e) {
				logger.error(e.getMessage());
				result =  new Result(1,"操作成功");
			}
    	}else{
    		result =  new Result(1,"操作成功");
    	}
    	return result;
    }
	
	 /**
     * 跳转到资源页面
     * @return
     */
    @RequestMapping(value = "/gotoBsResourceDetail.do")
    public String  gotoBsResourceDetail(Long id,Model model) {
    	if(id != null){
    		BsResource bsResource = bsResourceService.getBsResource(id);
        	model.addAttribute("bsResource", bsResource);
    	}
    	return "/permission/bsResource/bsResourceDetail";
    }
	
    /**
     * 删除资源数据
     * @return
     */
    @RequestMapping(value = "/deleteBsResource.do")
    public @ResponseBody  Object deleteBsResource(HttpServletRequest request,Long id) {
    	Result result = null;
    	try {

            List list = bsResourceService.findBsResourceListByParentId(id);
            if(list!=null && list.size()>0){
                return  new Result(1,"存在子节点，删除失败!");
            }
			bsResourceService.deleteBsResource(id);
			result = new Result(1,"操作成功");
		} catch (Exception e) {
			logger.error(e);
			result =  new Result(1,"操作失败!");
		}
    	return result;
    }
}