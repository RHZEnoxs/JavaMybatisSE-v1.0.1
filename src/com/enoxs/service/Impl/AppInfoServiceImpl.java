package com.enoxs.service.Impl;

import com.enoxs.data.dao.AppInfoMapperCustom;
import com.enoxs.data.gen.dao.AppInfoMapper;
import com.enoxs.data.gen.model.AppInfo;
import com.enoxs.service.AppInfoService;

import java.util.List;

public class AppInfoServiceImpl implements AppInfoService {
    public AppInfoMapperCustom appInfoMapperCustom;

    @Override
    public List<AppInfo> selectAll() {
        return appInfoMapperCustom.selectAll();
    }

    @Override
    public List<AppInfo> selectByAppName(String appName){
        return appInfoMapperCustom.selectByAppName(appName);
    }
}
