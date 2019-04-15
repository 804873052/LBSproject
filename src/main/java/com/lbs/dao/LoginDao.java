package com.lbs.dao;

import com.lbs.entity.Login;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//注解SqlResource指明该接口方法映射的SQL语句所在的文件的路径
@SqlResource("login")
public interface LoginDao extends BaseMapper {
    public List<Login> Login(@Param("username") String username, @Param("password") String password);
    public List<Login> Forget(@Param("username") String username, @Param("password") String password);

    List<Login> InsertStudent(@Param("username") String username, @Param("password") String password);
}
