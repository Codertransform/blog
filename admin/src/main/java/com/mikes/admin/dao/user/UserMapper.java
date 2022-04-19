package com.mikes.admin.dao.user;

import com.mikes.admin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findList(User user);

    User get(User user);

    int insert(User user);

    int update(User user);

    int delete(User user);
}
