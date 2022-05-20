package com.mikes.admin.service.Impl;

import com.mikes.admin.dao.user.RoleMapper;
import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.user.Role;
import com.mikes.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Result<List<Role>> findList(Role role) {
        List<Role> infos = roleMapper.findList(role);
        return Result.success(infos.size(),infos);
    }

    @Override
    public Role get(Role role) {
        return null;
    }

    @Override
    public int save(Role role) {
        return 0;
    }

    @Override
    public int delete(Role role) {
        return 0;
    }
}
