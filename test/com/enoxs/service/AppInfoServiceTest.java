package com.enoxs.service;

import com.enoxs.data.dao.AppInfoMapperCustom;
import com.enoxs.data.gen.dao.AppInfoMapper;
import com.enoxs.data.gen.model.AppInfo;
import com.enoxs.service.Impl.AppInfoServiceImpl;
import com.enoxs.util.MyBatisUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AppInfoServiceTest {
    AppInfoService appInfoService;
    @Before
    public void setUp() throws Exception {
        MyBatisUtil.start("mybatis-config.xml");
        MyBatisUtil.sqlSession.getMapper(AppInfoMapper.class);
        appInfoService = new AppInfoServiceImpl();
        AppInfoMapperCustom appInfoMapperCustom = MyBatisUtil.sqlSession.getMapper(AppInfoMapperCustom.class);
        ((AppInfoServiceImpl) appInfoService).appInfoMapperCustom = appInfoMapperCustom;
    }

    @After
    public void tearDown() throws Exception {
        MyBatisUtil.done();
    }

    @Test
    public void selectAll() {
        List<AppInfo> lstAppInfo = appInfoService.selectAll();
        assertTrue(lstAppInfo.size() > 0);
    }

    @Test
    public void selectByAppName() {
        appInfoService.selectByAppName("JavaProjSE-v1.0.1");
    }
}