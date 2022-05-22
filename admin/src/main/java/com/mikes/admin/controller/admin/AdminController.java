package com.mikes.admin.controller.admin;

import com.mikes.admin.entity.enumeration.Account;
import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.user.UserInfo;
import com.mikes.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"","/"})
    public String index(UserInfo userInfo, Model model){
        model.addAttribute("title", "管理员信息");
        model.addAttribute("userInfo", userInfo);
        return "admin/index";
    }

    @RequestMapping(value = "/edit")
    public String edit(UserInfo userInfo, Model model){
        model.addAttribute("title", "管理员信息编辑");
        model.addAttribute("userInfo", userService.get(userInfo));
        return "admin/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public Result<UserInfo> save(UserInfo userInfo){
        return userService.save(userInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public Result<?> delete(UserInfo userInfo){
        return userService.delete(userInfo);
    }

    @ResponseBody
    @PostMapping(value = "/userInfo")
    public Result<List<UserInfo>> users(UserInfo userInfo){
        return userService.findList(userInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/check")
    public Result<?> check(UserInfo userInfo){
        return userService.check(userInfo);
    }
}
