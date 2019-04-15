package com.lbs.controller;
/**
 * 企业列表
 */

import com.lbs.entity.Bloggers;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BloggersController {
    @Autowired
    SQLManager sqlManager;

    /**
     * 查询bloggers表中的所有数据
     */
    @RequestMapping("/bloggers")
        public List<Bloggers> blooger(){
            Query<Bloggers> query = sqlManager.query(Bloggers.class);   //单表查询
            List<Bloggers> list = query.select();
            System.out.println(list);
            System.out.println(list.get(1));
            list.hashCode();
            return  list;
    }
}
