package com.mikes.admin.dao.system.user;

import com.mikes.admin.entity.system.user.Role;
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
