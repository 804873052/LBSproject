package com.lbs.service;

import com.lbs.entity.Login;
import com.lbs.entity.User;
import org.beetl.sql.core.annotatoin.Param;

import java.util.List;

public interface LoginService {
    List<User> Login(String username, String password);
    List<User> Forget(String username,String password);
    List<User> InsertStudent(String username,String password);
   void InsertUser(String username, String password);
}
