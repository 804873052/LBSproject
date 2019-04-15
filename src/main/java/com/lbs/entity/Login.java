package com.lbs.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    public Login(){}

    public String getUsername() {
        return username;
    }
//    @NotBlank(message = "用户名不能为空！！")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
