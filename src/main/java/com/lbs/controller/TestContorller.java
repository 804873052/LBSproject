package com.lbs.controller;

import com.lbs.entity.Bloggers;
import com.lbs.entity.Products;
import com.lbs.entity.User;
import com.lbs.service.ProductsService;
import jdk.nashorn.internal.objects.annotations.Where;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.text.resources.FormatData;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TestContorller {
    @Autowired
    SQLManager sqlManager;
    @Autowired
    ProductsService productService;
    @RequestMapping("/test")
    public void testProduct(){
        Query<Products> query = sqlManager.query(Products.class);   //单表查询
        List<Products> list = query.select();
        System.out.println(list);

        System.out.println("###############");
        List<Products> list1 = productService.selectItemNumber(1400);
        System.out.println(list1);
//        productService.deleteProduct(1400);
//        List<Products> list1 = sqlManager.query(Products.class).select("itemNumber");
//        System.out.println(list1);
    }

    /**
     * 可能是vue资源引入的问题，重复了？？
     * @return
     */
//    测试beetl模板引擎渲染页面，并向页面传值
//    @GetMapping("/test1")
//    @RequestMapping
//    public String testBeetl(HttpServletRequest request){
//        request.setAttribute("beetl","hello beetl");
//        request.getSession().setAttribute("test","test session");//共享变量session
//        return "test1.html";
//    }
//    @GetMapping("/test2")
//    public String testBeetl2(){
//        return "test2.html";
//    }
    //
    @GetMapping("/test_index")
    public String test_index(HttpServletRequest request, HttpSession session) {
        session.setAttribute("testSession","sesseion"); //需要${session.testSession}
        request.setAttribute("testRequest","request");//直接&{name}在模板中使用
        return "test_index.html";
    }

    @GetMapping("test_blogger")
    @ResponseBody
    public List<Bloggers> testBlogger() throws ParseException {
        Query<Bloggers> query = sqlManager.query(Bloggers.class);   //单表查询
        List<Bloggers> list = query.select();
//        System.out.println(list);
//        System.out.println(list.get(1).getDate_add().getClass());
        System.out.println(list.get(0).getDate_add());
        Date date = list.get(0).getDate_add();
        /*
        转化时间格式？？
         */
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.format(date);
//        System.out.println(list.get(0).getDate_add());
        return list;

    }
    @GetMapping("/test/get")
    @ResponseBody
    public User testGet(){
        User user = (User) sqlManager.query(User.class).select("username").get(0);
        return user;
    }

}
