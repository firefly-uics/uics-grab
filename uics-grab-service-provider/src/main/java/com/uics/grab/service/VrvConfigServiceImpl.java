package com.uics.grab.service;

import com.uics.grab.entity.VrvConfig;
import org.dubbo.x.repository.DaoBase;
import org.dubbo.x.service.CURDServiceBase;
import com.uics.grab.repository.VrvConfigDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  vrv配置信息
* Created by tom on 2016-12-07 14:34:59.
 */
public class VrvConfigServiceImpl extends CURDServiceBase<VrvConfig> implements VrvConfigService {
    @Autowired
    private VrvConfigDao vrvConfigDao;

    @Override
    public DaoBase<VrvConfig> getDao() {
        return vrvConfigDao;
    }
}
