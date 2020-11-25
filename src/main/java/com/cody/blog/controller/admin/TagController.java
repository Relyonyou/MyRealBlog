package com.cody.blog.controller.admin;

import com.cody.blog.entity.Tag;
import com.cody.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Cody
 * @date 2020/11/15 - 22:03
 */

@RequestMapping("/admin")
@Controller
public class TagController {

    @Autowired
    TagService tagService;

    /**
     * @param
     * @param pageable
     * @param model
     * @return java.lang.String
     * @methodname getTags
     */
    @GetMapping("/tags")
    public String getTagsList(@PageableDefault(size = 6, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("page", tagService.listTag(pageable));
        return "admin/tags";
    }

    /*@PostMapping("tags/input")
    public String saveTag(Tag tag){

    }*/
    @GetMapping("/tags/{id}/input")
    public String editTagById(@PathVariable Long id , Model model){
        model.addAttribute("tag",tagService.getTag(id));
        return "admin/tags-input";
    }
    @GetMapping("/tags/input")
    public String editTag(Model model){
        Tag tag = new Tag();
        model.addAttribute("tag", tag);
        return "admin/tags-input";
    }
    @PostMapping("/tags")
    public String postTag(Tag tag, RedirectAttributes attributes){
//        String tagName = "";
//        Tag t = tagService.getTagByName(tag.getName());
//        tagName = t.getName();
//        if("".equals(tagName)){
//            attributes.addFlashAttribute("message", "此标签已经存在，请重新输入!");
//            return "redirect:/admin/tags-input";
//        }
        if(tag.getName()==null||" ".equals(tag.getName())){
            attributes.addFlashAttribute("message", "标签名为空，请重新输入");
            return "redirect:/admin/tags-input";
        }else {
            attributes.addFlashAttribute("message", "操作成功");
            tagService.saveTag(tag);
            return "redirect:/admin/tags";
        }
    }

    @PostMapping("/tags/{id}")
    public String UpdateTag(@PathVariable Long id , Tag tag,RedirectAttributes attributes){
        tagService.updateTag(id, tag);
        attributes.addFlashAttribute("message", "更新成功");
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String deleteTag(@PathVariable Long id,RedirectAttributes redirectAttributes) {
        tagService.deleteTag(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/tags";
    }

}
