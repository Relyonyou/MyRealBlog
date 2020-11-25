package com.cody.blog.controller;

import com.cody.blog.entity.Blog;
import com.cody.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Cody
 * @date 2020/11/24 - 14:15
 */
public class BlogShowController {

   /* @Autowired
    private BlogService blogService;

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id , Model model){
        model.addAttribute("blog",blogService.getAndConvert(id));
        Blog blog1 = blogService.getAndConvert(id);
        return "blog";
    }*/

}
