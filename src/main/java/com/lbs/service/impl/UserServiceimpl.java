package com.lbs.service.impl;

import com.lbs.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    @Override
    public void test() {
        System.out.println("Test Service");
    }
}
