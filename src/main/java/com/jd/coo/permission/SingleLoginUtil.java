package com.jd.coo.permission;

import com.jd.common.web.LoginContext;
import com.jd.common.web.cookie.CookieUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by liumingxi on 2014/7/30.
 */
public class SingleLoginUtil {

    private final static Log log = LogFactory.getLog(SingleLoginUtil.class);

    /**
     * 读取cookie
     */
    private CookieUtils cookieUtils;

    private String hrm_auth_cookie_name;

    private String login_cookie_name;

    //用户登录id在请求属性中的名称
    private String userId_requestAttributeName = null;


    private void removeLoginContext() {
        LoginContext.remove();
    }

    public void logout(HttpServletResponse response) {
        cookieUtils.deleteCookie(response,login_cookie_name);
        cookieUtils.deleteCookie(response,hrm_auth_cookie_name);
        removeLoginContext();
    }


    public CookieUtils getCookieUtils() {
        return cookieUtils;
    }

    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }

    public String getUserId_requestAttributeName() {
        return userId_requestAttributeName;
    }

    public void setUserId_requestAttributeName(String userId_requestAttributeName) {
        this.userId_requestAttributeName = userId_requestAttributeName;
    }

    public String getHrm_auth_cookie_name() {
        return hrm_auth_cookie_name;
    }

    public void setHrm_auth_cookie_name(String hrm_auth_cookie_name) {
        this.hrm_auth_cookie_name = hrm_auth_cookie_name;
    }

    public String getLogin_cookie_name() {
        return login_cookie_name;
    }

    public void setLogin_cookie_name(String login_cookie_name) {
        this.login_cookie_name = login_cookie_name;
    }
}
