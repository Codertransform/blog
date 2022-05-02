package com.mikes.admin.service.Impl;

import com.mikes.admin.dao.user.UserMapper;
import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.user.UserInfo;
import com.mikes.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<List<UserInfo>> findList(UserInfo userInfo) {
        return Result.success(userMapper.findList(userInfo));
    }

    @Override
    public UserInfo get(UserInfo userInfo) {
        return userMapper.get(userInfo);
    }

    @Override
    public int save(UserInfo userInfo) {
        return 0;
    }

    @Override
    public int delete(UserInfo userInfo) {
        return userMapper.delete(userInfo);
    }
}
