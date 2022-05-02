package com.mikes.admin.controller.admin;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.user.UserInfo;
import com.mikes.admin.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = {"","/"})
    public String index(UserInfo userInfo, Model model){
        model.addAttribute("userInfo", userInfo);
        return "admin/index";
    }

    @ResponseBody
    @GetMapping(value = "/user")
    public Result<List<UserInfo>> users(UserInfo userInfo){
        return userService.findList(userInfo);
    }


}
