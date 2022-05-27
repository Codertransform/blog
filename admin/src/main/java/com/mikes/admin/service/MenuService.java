package com.mikes.admin.service;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.Menu;

import java.util.List;

public interface MenuService {

    Result<List<Menu>> findList(Menu menu);

    List<Menu> findAll(Menu menu);

    Menu get(Menu menu);

    Result<Menu> save(Menu menu);

    Result<?> delete(Menu menu);
}
