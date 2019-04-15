package com.lbs.controller;

import com.lbs.entity.Login;
import com.lbs.entity.User;
import com.lbs.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController extends Login{

    //渲染登入页面
//    @RequestMapping(value = {"","login.html"},method = RequestMethod.G)
    @GetMapping({"","login.html"})
    @ResponseBody
    public ModelAndView Index(){
        ModelAndView view = new ModelAndView("login.html");
        return view;
    }
    //管理主页面
    @RequestMapping("index.html")
//    @ResponseBody
    public String IndexUser(){
        return "index.html";
    }
    //企业
    @RequestMapping("products.html")
    @ResponseBody
    public ModelAndView Products(){
        ModelAndView view = new ModelAndView("products.html");
        return view;
    }
    //编辑企业信息
    @RequestMapping("edit-product.html")
    public String EditProducts(){
//        ModelAndView view = new ModelAndView("edit-product.html");
        return "edit-product.html";
    }
    //增加新企业
    @RequestMapping("add-product.html")
    @ResponseBody
    public ModelAndView AddProducts(){
        ModelAndView view = new ModelAndView("add-product.html");
        return view;
    }
    //
    @RequestMapping("qycp.html")
    public String qycp(){
//        ModelAndView view = new ModelAndView("edit-product.html");
        return "qycp.html";
    }

    //账户
    @RequestMapping("accounts.html")
    @ResponseBody
    public ModelAndView Accounts(){
        ModelAndView view = new ModelAndView("accounts.html");
        return view;
    }

    //处理登入请求
    @Autowired
    LoginService loginService;
//    @RequestMapping(value = "/login",produces = "application/json")
    @PostMapping(value = "/login",produces = "application/json")
    @ResponseBody
    public Map<String,Object> login(@RequestBody Map<String,Object> user, HttpSession session){ //session共享变量
        System.out.println("hello");
        Object username = user.get("username");
        Object password = user.get("password");
        Map<String,Object> map=new HashMap<String,Object>();
        System.out.println("TEST:" + username + password+
                            "User" + user);
            List<User> list=loginService.Login(username.toString(),password.toString());
            if(list.size() == 0){
                map.put("code",1);
                map.put("msg","用户名或密码错误");
//                return "login";
            }
            else{
                map.put("code",0);
                map.put("msg","信息正确");
                session.setAttribute("loginUser",username.toString());//设置用户名
                System.out.println("test:" + session.getAttribute("loginUser"));
//                return "redirect:/index.html";
            }
            return map;
    }
}
