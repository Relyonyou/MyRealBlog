package com.cody.blog.service.impl;

import com.cody.blog.dao.UserRepository;
import com.cody.blog.entity.User;
import com.cody.blog.service.UserService;
import com.cody.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cody
 * @date 2020/11/10 - 20:28
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

    @Override
    public User upPwd(String username,String password,String newpwd) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        user.setPassword(newpwd);
        return userRepository.save(user);
    }


}
