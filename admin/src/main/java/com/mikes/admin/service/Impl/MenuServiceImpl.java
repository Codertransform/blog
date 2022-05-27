package com.mikes.admin.service.Impl;

import com.mikes.admin.dao.user.MenuMapper;
import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.Menu;
import com.mikes.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        }
        return Result.success(menus.size(),menus);
    }

    @Override
    public List<Menu> findAll(Menu menu) {
        return menuMapper.findList(menu);
    }

    @Override
    public Menu get(Menu menu) {
        return menuMapper.get(menu);
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
}
