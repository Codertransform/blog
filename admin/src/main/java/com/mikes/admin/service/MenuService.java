package com.mikes.admin.service;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.user.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {

    Result<List<Menu>> findList(Menu menu);

    List<Menu> findTop();

    List<Menu> findAll(Menu menu);

    Menu get(Menu menu);

    Result<Menu> save(Menu menu);

    Result<?> delete(Menu menu);

    Map<Menu, List<Menu>> findSide(Menu menu);
}
