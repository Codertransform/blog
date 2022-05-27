package com.mikes.admin.dao.user;

import com.mikes.admin.entity.system.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> findList(Menu menu);

    Menu get(Menu menu);

    int insert(Menu menu);

    int update(Menu menu);

    int delete(Menu menu);
}
