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
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "/workspace")
    public String workSpace(Model model){
        return "workspace";
    }

    @GetMapping("/404")
    public String notFoundPage() {
        return "/error/404";
    }
    /**
     * 未授权
     */
    @GetMapping("/403")
    public String accessError() {
        return "/error/403";
    }
    /**
     * 服务器错误
     */
    @GetMapping("/500")
    public String internalError() {
        return "/error/500";
    }
}
