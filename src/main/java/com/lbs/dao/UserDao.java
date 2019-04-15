package com.lbs.dao;

import com.lbs.entity.User;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

@SqlResource("login")
public interface UserDao extends BaseMapper {
    public List<User> Login(@Param("username") String username, @Param("password") String password);
    public List<User> Forget(@Param("username") String username, @Param("password") String password);
    List<User> Bloggers();
    List<User> InsertStudent(@Param("username") String username, @Param("password") String password);
}
