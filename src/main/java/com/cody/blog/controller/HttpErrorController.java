package com.cody.blog.controller;

import com.cody.blog.entity.Result;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Cody
 * @date 2020/11/3 - 19:40
 */
@RestController
public class HttpErrorController implements ErrorController {
    private final static String ERROR_PATH = "/templates/error";

//    @ResponseBody
//    @RequestMapping(path = ERROR_PATH)
//    public Result error(HttpServletRequest request, HttpServletResponse response) {
//        //Result result = new WebResult("HttpErrorController error:"+response.getStatus());
//        Result result = new Result();
//        return result;
//    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
