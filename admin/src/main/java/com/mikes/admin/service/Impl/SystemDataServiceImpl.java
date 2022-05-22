package com.mikes.admin.service.Impl;

import com.mikes.admin.dao.system.SystemDataMapper;
import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.Data;
import com.mikes.admin.service.SystemDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemDataServiceImpl implements SystemDataService {

    @Autowired
    private SystemDataMapper dataMapper;

    @Override
    public Result<List<Data>> findList(Data data) {
        List<Data> dataList = dataMapper.findList(data);
        return Result.success(dataList);
    }

    @Override
    public Data get(Data data) {
        return dataMapper.get(data);
    }

    @Override
    public int save(Data data) {
        return 0;
    }

    @Override
    public int delete(Data data) {
        return dataMapper.delete(data);
    }
}
