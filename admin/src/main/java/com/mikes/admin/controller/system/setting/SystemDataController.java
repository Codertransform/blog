package com.mikes.admin.controller.system.setting;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.setting.Data;
import com.mikes.admin.service.SystemDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/system/setting/data")
public class SystemDataController {

    @Autowired
    private SystemDataService dataService;

    @RequestMapping(value = {"","/"})
    public String data(Data data, Model model){
        model.addAttribute("title", "数据字典");
        model.addAttribute("data", data);
        return "system/data/index";
    }

    @RequestMapping(value = "/add")
    public String add(Model model){
        model.addAttribute("title", "数据字典-添加");
        return "system/data/add";
    }

    @RequestMapping(value = "/edit")
    public String edit(Data data, Model model){
        model.addAttribute("title", "数据字典-编辑");
        model.addAttribute("data", dataService.get(data));
        return "system/data/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public Result<Data> save(Data data){
        return dataService.save(data);
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public Result<?> delete(Data data){
        return dataService.delete(data);
    }

    @ResponseBody
    @RequestMapping(value = "/getDatas")
    public Result<List<Data>> datas(Data data){
        return dataService.findList(data);
    }
}
