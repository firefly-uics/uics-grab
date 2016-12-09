package com.uics.grab.job;

import com.uics.grab.repository.H3cRealtimeFaultDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tom on 16/8/18.
 */
public class H3CJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(H3CJob.class);

    @Autowired
    private H3cRealtimeFaultDao h3cRealtimeFaultDao;

    public void sync(){
        LOGGER.info("sync h3c start...");
        try {

        }catch (Exception e){
            LOGGER.warn("sync h3c event error!", e);
        }
        LOGGER.info("sync h3c end.");
    }

}
