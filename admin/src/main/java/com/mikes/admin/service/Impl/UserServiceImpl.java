package com.mikes.admin.service.Impl;

import com.mikes.admin.dao.user.UserMapper;
import com.mikes.admin.entity.user.User;
import com.mikes.admin.service.UserSerrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserSerrvice {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findList(User user) {
        return userMapper.findList(user);
    }

    @Override
    public User get(User user) {
        return userMapper.get(user);
    }

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return userMapper.delete(user);
    }
}
