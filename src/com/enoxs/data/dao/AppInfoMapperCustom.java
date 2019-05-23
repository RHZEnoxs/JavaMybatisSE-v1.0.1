package com.enoxs.data.dao;

import com.enoxs.data.gen.dao.AppInfoMapper;
import com.enoxs.data.gen.model.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapperCustom extends AppInfoMapper {
    List<AppInfo> selectByAppName(@Param(value="appName") String appName);
}
