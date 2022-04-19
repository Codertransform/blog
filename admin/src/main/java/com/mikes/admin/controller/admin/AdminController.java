package com.mikes.admin.controller.admin;

import com.mikes.admin.entity.user.User;
import com.mikes.admin.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = {"","/"})
    public String index(User user, Model model){
        model.addAttribute("user", user);
        return "admin/index";
    }

    @ResponseBody
    @RequestMapping(value = "/user")
    public List<User> users(User user){
        return userService.findList(user);
    }
}
