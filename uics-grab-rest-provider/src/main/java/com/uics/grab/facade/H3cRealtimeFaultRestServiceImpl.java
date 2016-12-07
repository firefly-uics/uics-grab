package com.uics.grab.facade;

import com.uics.grab.entity.H3cRealtimeFault;
import org.dubbo.x.service.CURDService;
import org.dubbo.x.facade.RestServiceBase;
import com.uics.grab.service.H3cRealtimeFaultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * h3c告警信息
* Created by tom on 2016-12-07 14:34:58.
 */
public class H3cRealtimeFaultRestServiceImpl extends RestServiceBase<H3cRealtimeFault> implements H3cRealtimeFaultRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(H3cRealtimeFaultRestServiceImpl.class);

    private H3cRealtimeFaultService h3cRealtimeFaultService;

    public H3cRealtimeFaultService getH3cRealtimeFaultService() {
        return h3cRealtimeFaultService;
    }

    public void setH3cRealtimeFaultService(H3cRealtimeFaultService h3cRealtimeFaultService) {
        this.h3cRealtimeFaultService = h3cRealtimeFaultService;
    }

    @Override
    public CURDService<H3cRealtimeFault> getService() {
        return h3cRealtimeFaultService;
    }

}
