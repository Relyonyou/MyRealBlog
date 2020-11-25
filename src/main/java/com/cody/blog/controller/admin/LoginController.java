package com.cody.blog.controller.admin;

import com.cody.blog.entity.User;
import com.cody.blog.service.UserService;
import com.cody.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Cody
 * @date 2020/11/10 - 20:32
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping({"/", "/index", ""})
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名或者密码错误");
            /**
             * 重定向 页面拿不到model的值
             */
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

    /**
     * 修改密码
     */
    @GetMapping("/change")
    public String change() {
        return "admin/Changepwd";
    }

    @GetMapping("/updatepwd")
    public  String changePwd(RedirectAttributes redirectAttributes , HttpSession session,@RequestParam String oldpwd,
                             @RequestParam String newpwd,@RequestParam String newpwd_r){

        User user = (User) session.getAttribute("user");

        User user1 = userService.checkUser(user.getUsername(), oldpwd);
        if (user1 != null) {
            if (newpwd.equals(newpwd_r) && !newpwd.equals(oldpwd)) {
                userService.upPwd(user.getUsername(), oldpwd, newpwd);
                redirectAttributes.addFlashAttribute("msg", "密码修改成功，请重新登录");
                return "redirect:/admin/index";
            } else {
                redirectAttributes.addFlashAttribute("msg", "两次密码输入不一致，请重新输入");
                return "redirect:/admin/Changepwd";
            }

        } else {
            redirectAttributes.addFlashAttribute("msg", "原密码输入有误，请重新输入");
            return "redirect:/admin/Changepwd";
        }

    }

}
