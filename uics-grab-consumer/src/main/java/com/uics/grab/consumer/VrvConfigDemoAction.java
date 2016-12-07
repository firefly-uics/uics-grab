package com.uics.grab.consumer;


import com.alibaba.fastjson.JSON;
import com.uics.grab.entity.VrvConfig;
import com.uics.grab.service.VrvConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
* Created by tom on 2016-12-07 14:34:59.
 */
public class VrvConfigDemoAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(VrvConfigDemoAction.class);
    private VrvConfigService vrvConfigService;

    public VrvConfigService getVrvConfigService() {
        return vrvConfigService;
    }

    public void setVrvConfigService(VrvConfigService vrvConfigService) {
        this.vrvConfigService = vrvConfigService;
    }

    public void start() throws Exception {
        List<VrvConfig> vrvConfigs = vrvConfigService.listAll();
        assert(vrvConfigs != null);
        assert(vrvConfigs.size() == 1);

        LOGGER.info("list all:{}", JSON.toJSON(vrvConfigs));
    }
}
