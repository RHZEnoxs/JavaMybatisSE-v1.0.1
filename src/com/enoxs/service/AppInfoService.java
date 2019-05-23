package com.enoxs.service;

import com.enoxs.data.gen.model.AppInfo;

import java.util.List;

public interface AppInfoService {
    List<AppInfo> selectAll();

    List<AppInfo> selectByAppName(String appName);
}
