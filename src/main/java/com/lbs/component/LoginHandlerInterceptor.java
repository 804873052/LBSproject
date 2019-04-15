//package com.lbs.component;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 登陆检查，
// */
//@Component
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//    //目标方法执行之前
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("实现拦截器...........");
//        Object user = request.getSession().getAttribute("loginUser");
//        System.out.println("User:"+user);
//        if(user == null){
//            //未登陆，返回登陆页面
//            request.setAttribute("msg","没有权限请先登陆");
//            request.getRequestDispatcher("/login.html").forward(request,response);  //转发到login.html页面
//            System.out.println("user == null");
//            return false;
//        }else{
//            //已登陆，放行请求
//            return true;
//        }
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}
