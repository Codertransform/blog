package com.mikes.admin.dao.user;

import com.mikes.admin.entity.user.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<Role> findList(Role role);

    Role get(Role role);

    int insert(Role role);

    int update(Role role);

    int delete(Role role);
}
