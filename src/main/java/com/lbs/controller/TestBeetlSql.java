package com.lbs.controller;

import com.lbs.dao.UserDao;
import com.lbs.entity.User;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.mapping.BeanProcessor;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestBeetlSql {
    @Autowired
    SQLManager sqlManager;

    @GetMapping("test01")
    public void test01(){
        /**
         * Query的使用（Query查询器）
         */
        Query<User> query = sqlManager.query(User.class);
        List<User> list = query.andLike("username","%d%")   //模糊查询Like
                .andIsNotNull("password")
                .orderBy("id desc")     //倒序
                .select();
        System.out.println(list);
        /**
         * 直接使用数据库字段可能不妥，可能会重构
         * 这种方式必须在JDK8以上
         */
        List<User> list1 = sqlManager.lambdaQuery(User.class)   //lambda表达式
                .andEq(User::getUsername,"zd")  //username = #"zd"#
                .orderBy(User::getId)
                .select();
        System.out.println(list1);
        System.out.println();
    }

    /**
     * Mapper接口也提供了，获取Query的方法
     */
    public void test02(){
        UserDao userDao = sqlManager.getMapper(UserDao.class);
        Query<User> query = userDao.createQuery();
    }
    /**
     * SELECT * FROM `user` WHERE `id` BETWEEN 1 AND 1640 AND `name` LIKE '%t%' AND `password` IS NOT NULL ORDER BY id desc
     */
    @GetMapping("test03")
    public void test03(){
        Query<User> query = sqlManager.query(User.class);
        List<User> list = query.andBetween("id","1","3")
                .andLike("username","%d%")
                .andIsNotNull("password")
                .orderBy("id desc")
                .select();
        for (User temp:list
             ) {
            System.out.print("id:" + temp.getId()+"\t");
            System.out.print("Username:" + temp.getUsername()+"\t");
            System.out.println("Password:" + temp.getPassword());
        }

    }

    /**
     * 测试：single,unique查询
     * (single查询，查询出一条，如果没有，返回null；)
     * (unique查询和single稍微不同，他是查询一条，如果没有或者有多条，抛异常)
     * single:  SELECT * FROM `user` WHERE `id` = 1642 limit 0 , 1
     * unique:  SELECT * FROM `user` WHERE `id` = 1642 limit 0 , 2
     */
    @GetMapping("test04")
    public void test04(){
        Query<User> query = sqlManager.query(User.class);

        User single = query
                .andEq("id",3)
                .limit(1,2)
                .single();
        System.out.println(single.getId());

        User unique = query
                .andEq("id",5)
                .limit(1,2)
                .unique();
        System.out.println(unique.getId());
    }

    /**
     * 测试：count
     * ( SELECT COUNT(1) FROM `user` WHERE `name` = ? OR `id` = ? limit 0 , 10)
     */
    @GetMapping("test05")
    public void test05(){
        Query<User> query = sqlManager.query(User.class);
        long count = query
                .andEq("username","zd")
                .orEq("id","1")
                .limit(1,10)
                .count();
        System.out.println(count);
    }

    /**
     * 分组查询
     * (SELECT * FROM `user` WHERE `id` IN(1637, 1639, 1640 ) GROUP BY name )
     */
    @GetMapping("test06")
    public void test06(){
        Query<User> query = sqlManager.query(User.class);
        List<User> list = query
                .andIn("id", Arrays.asList(1,3,5))
                .groupBy("username")
//                .having(query.condition().andIsNotNull("password"))   //筛选
                .select();
        for (User temp:list
             ) {
            System.out.println("ID:" + temp.getId());
        }
    }
}


