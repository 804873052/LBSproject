package com.lbs.service.impl;


import com.lbs.dao.LoginDao;
import com.lbs.dao.UserDao;
import com.lbs.entity.Login;
import com.lbs.entity.User;
import com.lbs.service.LoginService;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.SQLReady;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceimpl implements LoginService {
    @Autowired
    UserDao userDao;
    @Override
    public List<User> Login(String username, String password) {
        List<User> list = userDao.Login(username,password);
        return list;
//        return null;
    }

    @Override
    public List<User> Forget(String username, String password) {
        List<User> list = userDao.Forget(username,password);
        return list;
    }

    @Override
    public List<User> InsertStudent(String username,String password){
        List<User> logins = userDao.InsertStudent(username,password);
        return logins;
    }

    @Autowired
    SQLManager sqlManager;
    @Override
    public void InsertUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("InsertU:"+user.getUsername()+"\n InsertP:"+user.getPassword());
        sqlManager.insert(user);
        return;
    }
}
