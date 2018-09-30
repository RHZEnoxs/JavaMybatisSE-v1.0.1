package com.enoxs.data.gen.dao;

import com.enoxs.data.gen.model.AppInfo;
import java.util.List;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    AppInfo selectByPrimaryKey(Long id);

    List<AppInfo> selectAll();

    int updateByPrimaryKey(AppInfo record);
}