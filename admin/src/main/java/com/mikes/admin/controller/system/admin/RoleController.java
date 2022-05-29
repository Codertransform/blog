package com.mikes.admin.controller.system.admin;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.user.Role;
import com.mikes.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/system/admin/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = {"","/"})
    public String index(Role role, Model model){
        model.addAttribute("title","角色信息");
        model.addAttribute("role",role);
        return "admin/role/index";
    }

    @RequestMapping(value = "/edit")
    public String edit(Role role, Model model){
        model.addAttribute("title", "角色信息修改");
        model.addAttribute("role", roleService.get(role));
        model.addAttribute("roleList", roleService.findAll(new Role()));
        return "admin/role/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public Result<Role> save(Role role){
        return roleService.save(role);
    }

    @ResponseBody
    @RequestMapping(value = "/infos")
    public Result<List<Role>> findInfos(Role role){
        return roleService.findList(role);
    }
}
