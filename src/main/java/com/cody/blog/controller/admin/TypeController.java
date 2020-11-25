package com.cody.blog.controller.admin;

import com.cody.blog.entity.Tag;
import com.cody.blog.entity.Type;
import com.cody.blog.service.TypeService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


/**
 * @author Cody
 * @date 2020/11/12 - 18:41
 */
@Validated
@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    TypeService typeService;

    //Pageable将前端封装好的信息打包回来
    @GetMapping("/types")
    public String getTypes(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types";

    }

    @GetMapping("types/input")
    public String input(Model model) {
        Type type = new Type();
        model.addAttribute("type", type);
        return "admin/type-input";
    }


    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/type-input";
    }

    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
//        //判断重名
//        if (type1.getName() != null) {
//            result.rejectValue("name", "nameError", "分类已存在");
//        }
//        if (result.hasErrors()) {
//            return "admin/type-input";
//        }
        Type t = typeService.saveType(type);
        if (t == null) {
            //标签为空
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/admin/types";
    }

    @ApiOperation(value = "/types/{id}",produces = "application/json")
    @PostMapping("/types/{id}")
    public String editPost(@Valid @RequestBody  Type type, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        //判断重名
        if (type1.getName() != null) {
            result.rejectValue("name", "nameError", "分类已存在");
        }
        if (result.hasErrors()) {
            return "admin/type-input";
        }
        Type t = typeService.updateType(id, type);
        if (t == null) {
            //标签为空
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }
}
