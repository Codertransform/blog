package com.mikes.admin.service;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.user.User;

import java.util.List;

public interface UserSerrvice {

    Result<List<User>> findList(User user);

    User get(User user);

    int save(User user);

    int delete(User user);
}
