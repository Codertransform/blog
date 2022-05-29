package com.mikes.admin.controller.system.admin;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.user.Menu;
import com.mikes.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/system/admin/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = {"","/"})
    public String index(Menu menu, Model model){
        model.addAttribute("title", "菜单管理");
        model.addAttribute("menu", menu);
        return "admin/menu/index";
    }

    @RequestMapping(value = "/add")
    public String add(Menu menu, Model model){
        model.addAttribute("title", "菜单信息添加");
        model.addAttribute("menus", menuService.findAll(menu));
        return "admin/menu/add";
    }

    @RequestMapping(value = "/edit")
    public String edit(Menu menu, Model model){
        model.addAttribute("title", "菜单信息编辑");
        model.addAttribute("menu", menuService.get(menu));
        model.addAttribute("menus", menuService.findAll(new Menu()));
        return "admin/menu/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public Result<Menu> save(Menu menu){
        System.out.println(menu);
        return menuService.save(menu);
    }

    @ResponseBody
    @RequestMapping(value = "/getMenus")
    public Result<List<Menu>> getDatas(Menu menu){
        return menuService.findList(menu);
    }
}
