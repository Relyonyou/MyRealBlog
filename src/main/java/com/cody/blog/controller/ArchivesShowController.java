package com.cody.blog.controller;

import com.cody.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Cody
 * @date 2020/11/21 - 15:20
 */
@Controller
public class ArchivesShowController {
    @Autowired
    private BlogService blogService;
    /*
        map
    */
    @GetMapping("/archives")
    public String archives(Model model) {
        model.addAttribute("archiveMap",blogService.archiveBlog());
        model.addAttribute("blogcount", blogService.countBlog());
        return "archives";
    }
}
