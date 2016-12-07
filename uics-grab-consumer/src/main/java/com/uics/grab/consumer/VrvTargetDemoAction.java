package com.uics.grab.consumer;


import com.alibaba.fastjson.JSON;
import com.uics.grab.entity.VrvTarget;
import com.uics.grab.service.VrvTargetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
* Created by tom on 2016-12-07 14:34:58.
 */
public class VrvTargetDemoAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(VrvTargetDemoAction.class);
    private VrvTargetService vrvTargetService;

    public VrvTargetService getVrvTargetService() {
        return vrvTargetService;
    }

    public void setVrvTargetService(VrvTargetService vrvTargetService) {
        this.vrvTargetService = vrvTargetService;
    }

    public void start() throws Exception {
        List<VrvTarget> vrvTargets = vrvTargetService.listAll();
        assert(vrvTargets != null);
        assert(vrvTargets.size() == 1);

        LOGGER.info("list all:{}", JSON.toJSON(vrvTargets));
    }
}
