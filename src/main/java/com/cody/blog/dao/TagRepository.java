package com.cody.blog.dao;

import com.cody.blog.entity.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Cody
 * @date 2020/11/15 - 22:03
 */

public interface TagRepository extends JpaRepository<Tag,Long> {
    public Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
