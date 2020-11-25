package com.cody.blog.service;

import com.cody.blog.entity.Tag;
import com.cody.blog.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Cody
 * @date 2020/11/15 - 22:04
 */

public interface TagService {
    Tag saveTag( Tag tag);

    Tag getTag(Long id);

    //查验分类是否重复
    Tag getTagByName( String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);

    Tag updateTag( Long id, Tag tag);

    void deleteTag( Long id);
}
