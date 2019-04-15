package com.lbs.dao;

import com.lbs.entity.Bloggers;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.Date;
import java.util.List;

@SqlResource("bloggers")
public interface BloggersDao extends BaseMapper {
    List<com.lbs.entity.Bloggers> Bloggers();
}
