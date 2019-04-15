package com.lbs.service.impl;

import com.lbs.dao.BloggersDao;
import com.lbs.entity.Bloggers;
import com.lbs.service.BloggersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BloggersServicrImpl implements BloggersService {
    @Autowired
    BloggersDao bloggersDao;
    @Override
    public List<Bloggers> Bloggers() {
        List<Bloggers> bloggers = bloggersDao.Bloggers();
        System.out.println(bloggers);
        return bloggers;
    }
}
