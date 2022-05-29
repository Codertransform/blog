package com.mikes.admin.service;

import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.setting.Data;

import java.util.List;

public interface SystemDataService {

    Result<List<Data>> findList(Data data);

    Data get(Data data);

    Result<Data> save(Data data);

    Result<?> delete(Data data);
}
