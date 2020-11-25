package com.cody.blog.dao;

import com.cody.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Cody
 * @date 2020/11/10 - 20:29
 */
public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username , String password);
}
