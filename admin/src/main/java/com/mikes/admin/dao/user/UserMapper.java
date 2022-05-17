package com.mikes.admin.dao.user;

import com.mikes.admin.entity.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserInfo> findList(UserInfo userInfo);

    UserInfo get(UserInfo userInfo);

    void insert(UserInfo userInfo);

    void update(UserInfo userInfo);

    void updLoginTime(UserInfo userInfo);

    int updStatus(UserInfo userInfo);

    int delete(UserInfo userInfo);
}
