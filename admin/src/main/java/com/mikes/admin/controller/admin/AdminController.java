package com.mikes.admin.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = {"","/"})
    public String index(Model model){
        return "admin/index";
    }
}
