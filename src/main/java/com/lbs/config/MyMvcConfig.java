//package com.lbs.config;
//
//
//import com.lbs.component.LoginHandlerInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MyMvcConfig implements WebMvcConfigurer {
//
//    @Autowired
//    LoginHandlerInterceptor loginHandlerInterceptor;
//    // 这个方法是用来配置静态资源的，比如html，js，css，等等
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//    }
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/login.html").setViewName("login.html");
////        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/main.html").setViewName("index.html");
//    }
//
//    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/","/login.html","/login");
//    }
//
//}
