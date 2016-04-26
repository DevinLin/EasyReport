package com.jd.coo.permission.directive;

import com.jd.common.web.LoginContext;
import com.jd.coo.permission.condition.BsResourceCondition;
import com.jd.coo.permission.manager.BsResourceManager;
import org.apache.log4j.Logger;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.exception.TemplateInitException;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Writer;

/**
 * 权限自定义标签
 * User: qiaomu
 * Date: 14-8-13
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class PermissionDirective extends Directive {

    private static final Logger log = Logger.getLogger(PermissionDirective.class);

  

    @Resource
    private BsResourceManager bsResourceService;

    @Override
    public void init(RuntimeServices rs, InternalContextAdapter context, Node node) throws TemplateInitException {
       bsResourceService = (BsResourceManager) ApplicationContextUtils.getApplicationContext().getBean("BsResourceManagerImpl");
        super.init(rs, context, node);
    }

    /**
     * 指定指令名称
     * Return the name of this directive.
     *
     * @return The name of this directive.
     */
    @Override
    public String getName() {
        return "permission";
    }

    /**
     * 指定指令类型
     * Get the directive type BLOCK/LINE.
     *
     * @return The directive type BLOCK/LINE.
     */
    @Override
    public int getType() {
        return BLOCK;
    }

    /**
     * 指令内容的操作
     * How this directive is to be rendered
     *
     * @param internalContextAdapter
     * @param writer
     * @param node
     * @return True if the directive rendered successfully.
     * @throws IOException
     * @throws ResourceNotFoundException
     *
     * @throws ParseErrorException
     *
     * @throws MethodInvocationException
     *
     */
    @Override
    public boolean render(InternalContextAdapter internalContextAdapter, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
        // 获得缓存信息
        SimpleNode snRegion = (SimpleNode) node.jjtGetChild(0);
        // 获得资源码
        String resResourceCode = (String) snRegion.value(internalContextAdapter);
        // 判断当前用户是否有此连接权限
        //获取当前登录人的erp账号
        String erpNumber = LoginContext.getLoginContext().getPin();
        BsResourceCondition bsResourceCondition = new BsResourceCondition();
        bsResourceCondition.setCode(resResourceCode);
        bsResourceCondition.setUserCode(erpNumber);
        boolean flag = bsResourceService.findResourceByUserCodeAndResource(bsResourceCondition);
        if(!flag){
        	return false;
        }
        SimpleNode snKey = (SimpleNode) node.jjtGetChild(1);
        snKey.render(internalContextAdapter, writer);
        return false;
    }
}
