package com.mikes.admin.service;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.user.UserInfo;

import java.util.List;

public interface UserService {

    Result<List<UserInfo>> findList(UserInfo userInfo);

    UserInfo get(UserInfo userInfo);

    Result<UserInfo> save(UserInfo userInfo);

    Result<UserInfo> delete(UserInfo userInfo);
}
