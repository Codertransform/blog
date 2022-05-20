package com.mikes.admin.service;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.user.Role;

import java.util.List;

public interface RoleService {

    Result<List<Role>> findList(Role role);

    Role get(Role role);

    int save(Role role);

    int delete(Role role);
}
