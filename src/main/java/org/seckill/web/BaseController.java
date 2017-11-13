package org.seckill.web;

import org.seckill.entity.UserInfo;
import org.seckill.util.CommonTUtils;
import org.seckill.util.MapCache;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangj
 *
 * 抽象控制类，封装一些通用的用户方法
 */
public abstract class BaseController {

    protected MapCache cache = MapCache.single();

    public BaseController title(HttpServletRequest request,String title){
        request.setAttribute("title",title);
        return this;
    }

    public BaseController keywords(HttpServletRequest request, String keywords) {
        request.setAttribute("keywords", keywords);
        return this;
    }

    /**
     * 获取请求绑定的登录对象
     * @param request
     * @return
     */
    public UserInfo user(HttpServletRequest request){
        return CommonTUtils.getLoginUser(request);
    }


    public Integer getUid(HttpServletRequest request) {
        return this.user(request).getUid();
    }
}
