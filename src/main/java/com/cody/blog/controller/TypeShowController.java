package com.cody.blog.controller;

import com.cody.blog.entity.Type;
import com.cody.blog.service.BlogService;
import com.cody.blog.service.TypeService;
import com.cody.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Cody
 * @date 2020/11/21 - 14:29
 */
@Controller
public class TypeShowController {
    @Autowired
    TypeService typeService;

    @Autowired
    private BlogService blogService;
    @GetMapping("/types/{id}")
    public String types(@PageableDefault(size = 9, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable  Long id, Model model){
        List<Type> types = typeService.listTypeTop(1000);
        if(id ==-1){
            id = types.get(0).getId();
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types", types);
        model.addAttribute("page", blogService.listBlogs(pageable,blogQuery));
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}
