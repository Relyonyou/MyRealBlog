package com.cody.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Cody
 * @date 2020/11/21 - 15:49
 */
@Controller
public class AboutController {
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
