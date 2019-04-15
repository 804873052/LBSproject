package com.lbs.controller;

import com.lbs.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
@Controller
public class LBSController {
    @RequestMapping("/lbs.home")
    public @ResponseBody
    String test() {
        return "hello";
    }


//    /**
//     * Beetl模块
//     */
//    @RequestMapping("/test")
//    @ResponseBody
//    public ModelAndView index(){
////        System.out.println("ok");
//        ModelAndView view = new ModelAndView("/test1.html");
//        view.addObject("user", "张三");   //返回视图并且向视图提供数据
//        return view;
//    }
//    @RequestMapping("/user/test_get")
//    public @ResponseBody
//    Map<String,Object> test_get(){
//        Map<String,Object> data = new HashMap<String,Object>();
//        data.put("code",0);
//        data.put("msg","hello spring boot");
//        return data;
//    }
////    @Autowired
////    UserService userService;
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//    @RequestMapping("/user/test_sql")
//    public @ResponseBody String get_test() {
//        Integer n = jdbcTemplate.queryForObject("select count(*) from lbssource",Integer.class);
//        List list = jdbcTemplate.queryForList("select * from lbssource");
//        Map map = jdbcTemplate.queryForMap("select * from lbssource where userId=1");
//        return n.toString() + " \n" + list + " \n" +map;
//    }
////@PostMapping()
////@GetMapping()
//    @RequestMapping(value = "/test2")
//    @ResponseBody
//    public ModelAndView Test(){
//        ModelAndView modelAndView  = new ModelAndView("/login.html");
//        System.out.println("test");
//        return modelAndView;
//    }

    @Autowired
    LoginService loginService;

    @RequestMapping("/test.test")
    public ModelAndView Test(){
        ModelAndView view = new ModelAndView("test.html");
        return view;
    }
    @PostMapping("/insert_user")
    @ResponseBody
    public void InsertU(@RequestBody Map<String,Object> user){
        Object username = user.get("username");
        Object password = user.get("password");
        System.out.println("Username:"+username+"\n Password:"+password);
        loginService.InsertUser(username.toString(),password.toString());
        System.out.println("ok");
    }
}