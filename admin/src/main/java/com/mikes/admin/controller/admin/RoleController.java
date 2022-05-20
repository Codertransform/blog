package com.mikes.admin.controller.admin;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.user.Role;
import com.mikes.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = {"","/"})
    public String index(Role role, Model model){
        model.addAttribute("title","角色信息");
        model.addAttribute("role",role);
        return "role/index";
    }

    @ResponseBody
    @RequestMapping(value = "/infos")
    public Result<List<Role>> findInfos(Role role){
        return roleService.findList(role);
    }
}
