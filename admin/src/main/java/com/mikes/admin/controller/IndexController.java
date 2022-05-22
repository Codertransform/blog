package com.mikes.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "")
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"","/"})
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String index(Model model){
        model.addAttribute("title", "Blog管理系统");
        return "index";
    }

    @RequestMapping(value = "/workspace")
    public String workSpace(Model model){
        model.addAttribute("title", "欢迎页");
        return "workspace";
    }
}
