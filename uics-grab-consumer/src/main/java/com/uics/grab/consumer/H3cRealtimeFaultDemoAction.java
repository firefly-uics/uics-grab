package com.uics.grab.consumer;


import com.alibaba.fastjson.JSON;
import com.uics.grab.entity.H3cRealtimeFault;
import com.uics.grab.service.H3cRealtimeFaultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
* Created by tom on 2016-12-07 14:34:58.
 */
public class H3cRealtimeFaultDemoAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(H3cRealtimeFaultDemoAction.class);
    private H3cRealtimeFaultService h3cRealtimeFaultService;

    public H3cRealtimeFaultService getH3cRealtimeFaultService() {
        return h3cRealtimeFaultService;
    }

    public void setH3cRealtimeFaultService(H3cRealtimeFaultService h3cRealtimeFaultService) {
        this.h3cRealtimeFaultService = h3cRealtimeFaultService;
    }

    public void start() throws Exception {
        List<H3cRealtimeFault> h3cRealtimeFaults = h3cRealtimeFaultService.listAll();
        assert(h3cRealtimeFaults != null);
        assert(h3cRealtimeFaults.size() == 1);

        LOGGER.info("list all:{}", JSON.toJSON(h3cRealtimeFaults));
    }
}
