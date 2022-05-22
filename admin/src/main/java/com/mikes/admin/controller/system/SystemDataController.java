package com.mikes.admin.controller.system;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.Data;
import com.mikes.admin.entity.user.UserInfo;
import com.mikes.admin.service.SystemDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/system")
public class SystemDataController {

    @Autowired
    private SystemDataService dataService;

    @RequestMapping(value = "/data")
    public String data(Data data, Model model){
        model.addAttribute("title", "数据字典");
        model.addAttribute("data", data);
        return "system/data/index";
    }

    @ResponseBody
    @RequestMapping(value = "/data/datas")
    public Result<List<Data>> datas(Data data){
        return dataService.findList(data);
    }
}
