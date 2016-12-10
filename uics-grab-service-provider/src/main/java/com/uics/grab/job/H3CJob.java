package com.uics.grab.job;

import com.uics.grab.entity.H3cRealtimeFault;
import com.uics.grab.repository.H3cRealtimeFaultDao;
import com.uics.grab.service.H3cRealtimeFaultService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

/**
 * Created by tom on 16/8/18.
 */
public class H3CJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(H3CJob.class);

    private H3cRealtimeFaultService h3cRealtimeFaultService;

    @Autowired
    private H3cRealtimeFaultDao h3cRealtimeFaultDao;

    public void sync(){
        LOGGER.info("sync h3c start...");
        try {
            List<H3cRealtimeFault> h3cRealtimeFaultList = h3cRealtimeFaultService.parse(FileUtils.readFileToString(new File("/work/001_code/github/java/uics/uics-grab/uics-grab-service-provider/src/test/resources/third/h3c/realtimefault.html")));
            for (H3cRealtimeFault h3cRealtimeFault: h3cRealtimeFaultList){
                if (null == h3cRealtimeFaultDao.findByFaultId(h3cRealtimeFault.getFaultId())){
                    h3cRealtimeFaultDao.save(h3cRealtimeFault);
                }
            }
        }catch (Exception e){
            LOGGER.warn("sync h3c event error!", e);
        }
        LOGGER.info("sync h3c end.");
    }

    public H3cRealtimeFaultService getH3cRealtimeFaultService() {
        return h3cRealtimeFaultService;
    }

    public void setH3cRealtimeFaultService(H3cRealtimeFaultService h3cRealtimeFaultService) {
        this.h3cRealtimeFaultService = h3cRealtimeFaultService;
    }
}
