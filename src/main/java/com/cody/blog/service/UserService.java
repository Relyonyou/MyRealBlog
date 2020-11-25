package com.cody.blog.service;

import com.cody.blog.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Cody
 * @date 2020/11/10 - 20:26
 */
public interface UserService {
    User checkUser(String username , String password);

    User upPwd(String username,String password,String newpwd);
}
