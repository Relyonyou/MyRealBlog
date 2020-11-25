package com.cody.blog.dao;

import com.cody.blog.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Cody
 * @date 2020/11/12 - 18:09
 */
public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findByName(String name);

    @Query("select y from Type y ")
    List<Type> findTop(Pageable pageable);
}
