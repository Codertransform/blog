package com.mikes.admin.service.Impl;

import com.mikes.admin.dao.system.setting.SystemDataMapper;
import com.mikes.admin.entity.result.Result;
import com.mikes.admin.entity.system.setting.Data;
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
        return Result.success(dataList.size(),dataList);
    }

    @Override
    public Data get(Data data) {
        return dataMapper.get(data);
    }

    @Override
    public Result<Data> save(Data data) {
        if (data.getId() != 0){
            dataMapper.update(data);
            return Result.success(data);
        }else {
            dataMapper.insert(data);
            return Result.success(data);
        }
    }

    @Override
    public Result<?> delete(Data data) {
        if (dataMapper.delete(data) != 0){
            return Result.success(data);
        }else {
            return Result.failure();
        }
    }
}
