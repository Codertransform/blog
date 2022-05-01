package com.mikes.admin.service;

import java.util.List;

public interface BaseService<T> {

    List<T> findList(T t);

    T get(T t);

    int insert(T t);

    int update(T t);

    int delete(T t);
}
