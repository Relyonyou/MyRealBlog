package com.cody.blog.service;

import com.cody.blog.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Cody
 * @date 2020/11/12 - 18:06
 */
@Validated
public interface TypeService {

    Type saveType(@Valid Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    //查验分类是否重复
    Type getTypeByName(@Valid String name);


    Type updateType(@Valid Long id,@Valid Type type);

    void deleteType( Long id);
}
