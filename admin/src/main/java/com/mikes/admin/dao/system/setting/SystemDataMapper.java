package com.mikes.admin.dao.system.setting;

import com.mikes.admin.entity.system.setting.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemDataMapper {

    List<Data> findList(Data data);

    Data get(Data data);

    int insert(Data data);

    int update(Data data);

    int delete(Data data);
}
