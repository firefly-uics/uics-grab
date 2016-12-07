package com.uics.grab.facade;

import com.uics.grab.entity.VrvTarget;
import org.dubbo.x.service.CURDService;
import org.dubbo.x.facade.RestServiceBase;
import com.uics.grab.service.VrvTargetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * vrv监控指标统计信息
* Created by tom on 2016-12-07 14:34:58.
 */
public class VrvTargetRestServiceImpl extends RestServiceBase<VrvTarget> implements VrvTargetRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VrvTargetRestServiceImpl.class);

    private VrvTargetService vrvTargetService;

    public VrvTargetService getVrvTargetService() {
        return vrvTargetService;
    }

    public void setVrvTargetService(VrvTargetService vrvTargetService) {
        this.vrvTargetService = vrvTargetService;
    }

    @Override
    public CURDService<VrvTarget> getService() {
        return vrvTargetService;
    }

}
