package com.mikes.admin.controller;

import com.mikes.admin.entity.system.setting.Data;
import com.mikes.admin.entity.system.user.Menu;
import com.mikes.admin.service.MenuService;
import com.mikes.admin.service.SystemDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "")
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"","/"})
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String index(Menu menu, Model model){
        model.addAttribute("title", "Blog管理系统");
        model.addAttribute("topmenus", menuService.findTop());
        model.addAttribute("sidemenus", menuService.findSide(menu));
        return "index";
    }

    @RequestMapping(value = "/workspace")
    public String workSpace(Model model){
        model.addAttribute("title", "欢迎页");
        return "workspace";
    }
}
