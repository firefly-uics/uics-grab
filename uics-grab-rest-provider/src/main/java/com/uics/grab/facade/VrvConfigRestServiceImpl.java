package com.uics.grab.facade;

import com.uics.grab.entity.VrvConfig;
import org.dubbo.x.service.CURDService;
import org.dubbo.x.facade.RestServiceBase;
import com.uics.grab.service.VrvConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * vrv配置信息
* Created by tom on 2016-12-07 14:34:59.
 */
public class VrvConfigRestServiceImpl extends RestServiceBase<VrvConfig> implements VrvConfigRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VrvConfigRestServiceImpl.class);

    private VrvConfigService vrvConfigService;

    public VrvConfigService getVrvConfigService() {
        return vrvConfigService;
    }

    public void setVrvConfigService(VrvConfigService vrvConfigService) {
        this.vrvConfigService = vrvConfigService;
    }

    @Override
    public CURDService<VrvConfig> getService() {
        return vrvConfigService;
    }

}
