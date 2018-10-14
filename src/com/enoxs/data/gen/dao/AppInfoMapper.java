package com.enoxs.data.gen.dao;

import com.enoxs.data.gen.model.AppInfo;
import java.util.List;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppInfo record);

    AppInfo selectByPrimaryKey(Integer id);

    List<AppInfo> selectAll();

    int updateByPrimaryKey(AppInfo record);
}