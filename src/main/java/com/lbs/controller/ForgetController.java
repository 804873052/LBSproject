package com.lbs.controller;

import com.lbs.dao.BloggersDao;
import com.lbs.entity.Bloggers;
import com.lbs.entity.Login;
import com.lbs.entity.User;
import com.lbs.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ForgetController {
    @Autowired
    LoginService loginService;

    @PostMapping("/forget")
    public Map<String,Object> Forget(@RequestBody Map<String,Object> userforget){
        Map<String,Object> map = new HashMap();
        Object username = userforget.get("username");
        Object password = userforget.get("password");
        try{
            List<User> list=loginService.Login(username.toString(),password.toString());
            if(list.size() == 0){
                map.put("code",1);
                map.put("msg","用户不存在！");
            }
            else{
                map.put("code",0);
                map.put("msg","信息正确");
            }
        }
        catch (Exception ex){
            map.put("code",1);
            map.put("msg","访问异常");
        }
        return map;
    }


    @Autowired
    BloggersDao bloggersDao;
    //getdates
    @GetMapping("/getdates")
    @ResponseBody
    public List<Bloggers> GetDates(){
        System.out.println("test");
        Map<String,Object> map = new HashMap();
        List<Bloggers> list= bloggersDao.Bloggers();
        System.out.println(list);
        return list;
    }

//    //渲染test-index.html页面
//    @RequestMapping("test_index.html")
//    @ResponseBody
//    public ModelAndView test(){
//        ModelAndView view = new ModelAndView("test_index.html");
//        return view;
//    }
}
