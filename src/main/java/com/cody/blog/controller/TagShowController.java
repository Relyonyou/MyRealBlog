package com.cody.blog.controller;

import com.cody.blog.entity.Tag;
import com.cody.blog.entity.Type;
import com.cody.blog.service.BlogService;
import com.cody.blog.service.TagService;
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
 * @date 2020/11/21 - 14:50
 */
@Controller
public class TagShowController {
    @Autowired
    TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String types(@PageableDefault(size = 9, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id, Model model){
        List<Tag> tags = tagService.listTagTop(1000);
        if(id ==-1){
            id = tags.get(0).getId();
        }
        model.addAttribute("tags", tags);
        model.addAttribute("page", blogService.listBlogByTag(id,pageable));
        model.addAttribute("activeTagId", id);
        return "tags";
    }
}
