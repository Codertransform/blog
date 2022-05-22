package com.mikes.admin.service;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.Data;
import com.mikes.admin.entity.user.UserInfo;

import java.util.List;

public interface SystemDataService {

    Result<List<Data>> findList(Data data);

    Data get(Data data);

    int save(Data data);

    int delete(Data data);
}
