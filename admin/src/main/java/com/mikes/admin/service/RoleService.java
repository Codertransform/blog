package com.mikes.admin.service;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.user.Role;

import java.util.List;

public interface RoleService {

    Result<List<Role>> findList(Role role);

    Role get(Role role);

    Result<Role> save(Role role);

    Result<?> delete(Role role);

    List<Role> findAll(Role role);
}
