package com.sgg.admin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author huangruiqing
 * @Description 登陆检查
 * @date 2022-10-09 17:15
 */
public class LoginLnterceptor implements HandlerInterceptor {
    
    /**
     * @Description //TODO 目标方法执行前
     * @Author huangruiqing
     * @Date 17:17 2022/10/9
     * @Param [request, response, handler]
     * @return boolean
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        //检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        
        if(loginUser != null){
            
            //放行
            return true;
        }
        request.setAttribute("msg","请先登录");
//        response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
        
    }
    
    /**
     * @Description //TODO 目标方法执行完成以后
     * @Author huangruiqing
     * @Date 17:17 2022/10/9
     * @Param [request, response, handler, modelAndView]
     * @return void
     **/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
