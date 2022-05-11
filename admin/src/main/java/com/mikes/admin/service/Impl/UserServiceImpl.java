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
        List<UserInfo> userInfos = userMapper.findList(userInfo);
        for (UserInfo u : userInfos){
            if (u.getSex().equals("0")){
                u.setSex("女");
            }else {
                u.setSex("男");
            }
        }
        return Result.success(userInfos.size(),userInfos);
    }

    @Override
    public UserInfo get(UserInfo userInfo) {
        return userMapper.get(userInfo);
    }

    @Override
    public Result<UserInfo> save(UserInfo userInfo) {
        if (userInfo.getId() != 0) {
            userMapper.update(userInfo);
            return Result.success(userInfo);
        }else {
            userMapper.insert(userInfo);
            return Result.success(userInfo);
        }
    }

    @Override
    public int delete(UserInfo userInfo) {
        return userMapper.delete(userInfo);
    }
}
