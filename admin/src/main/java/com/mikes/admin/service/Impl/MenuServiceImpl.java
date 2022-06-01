package com.mikes.admin.service.Impl;

import com.mikes.admin.dao.system.user.MenuMapper;
import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.user.Menu;
import com.mikes.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Result<List<Menu>> findList(Menu menu) {
        List<Menu> menus = menuMapper.findList(menu);
        for (Menu m : menus){
            if (m.getDisplay() == 0){
                m.setDisp("显示");
            }else {
                m.setDisp("隐藏");
            }
            if (m.getLevel() == 1){
                m.setLev("顶级菜单");
            }else {
                m.setLev("侧边菜单");
            }
        }
        return Result.success(menus.size(),menus);
    }

    @Override
    public List<Menu> findTop(){
        Menu menu = new Menu();
        menu.setLevel(1);
        return menuMapper.findList(menu);
    }

    @Override
    public List<Menu> findAll(Menu menu) {
        return menuMapper.findList(menu);
    }

    @Override
    public Menu get(Menu menu) {
        menu = menuMapper.get(menu);
        return menu;
    }

    @Override
    public Result<Menu> save(Menu menu) {
        if (menu.getId() != 0){
            menuMapper.update(menu);
            return Result.success(menu);
        }else {
            menuMapper.insert(menu);
            return Result.success(menu);
        }
    }

    @Override
    public Result<?> delete(Menu menu) {
        if (menuMapper.delete(menu) != 0){
            return Result.success(menu);
        }else {
            return Result.failure();
        }
    }

    @Override
    public Map<Menu, List<Menu>> findSide(Menu menu) {
        System.out.println(menu);
        Map<Menu, List<Menu>> menus = new LinkedHashMap<>();
        if (menu.getParentId() != 0){
            List<Menu> second = menuMapper.findByParent(menu);
            for (Menu m : second){
                System.out.println(m);
                List<Menu> third = menuMapper.findByParent(m);
                for(Menu t : third){
                    System.out.println(t);
                }
                menus.put(m, third);
            }
        }else {
            List<Menu> child = menuMapper.findByParent(menu);
            List<Menu> second = new ArrayList<>();
            List<Menu> third = new ArrayList<>();
            for (Menu m : child) {
                if (m.getLevel() == 2) {
                    second.add(m);
                } else {
                    third.add(m);
                }
            }
            for (Menu m : second){
                List<Menu> menuList = new ArrayList<>();
                for (Menu m1 : third){
                    if (m1.getParentId() == m.getId()){
                        menuList.add(m1);
                    }
                }
                menus.put(m, menuList);
            }
        }
        return menus;
    }
}
