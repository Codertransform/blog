package com.mikes.admin.controller.admin;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.Menu;
import com.mikes.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/menu")
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
        model.addAttribute("menus", menuService.findAll(menu));
        return "admin/menu/add";
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public Result<Menu> save(Menu menu){
        return menuService.save(menu);
    }

    @ResponseBody
    @RequestMapping(value = "/getMenus")
    public Result<List<Menu>> getDatas(Menu menu){
        return menuService.findList(menu);
    }
}
