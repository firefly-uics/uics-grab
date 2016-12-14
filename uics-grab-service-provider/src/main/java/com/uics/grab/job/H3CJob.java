package com.uics.grab.job;

import com.uics.grab.entity.H3cRealtimeFault;
import com.uics.grab.repository.H3cRealtimeFaultDao;
import com.uics.grab.service.H3cRealtimeFaultService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * Created by tom on 16/8/18.
 */
public class H3CJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(H3CJob.class);
    private static final String JOB_NAME = "h3c";

    private H3cRealtimeFaultService h3cRealtimeFaultService;

    private JobEnv jobEnv;

    @Autowired
    private H3cRealtimeFaultDao h3cRealtimeFaultDao;

    public void sync(){
        LOGGER.info("sync {} start...",JOB_NAME);
        try {

            File file = new File(jobEnv.getProperty("temp.directory") + File.separator + jobEnv.getProperty("h3c.temp.dir.name") + File.separator + jobEnv.getProperty("h3c.temp.file.realtimefault.name"));

            List<H3cRealtimeFault> h3cRealtimeFaultList = h3cRealtimeFaultService.parse(FileUtils.readFileToString(file));
            for (H3cRealtimeFault h3cRealtimeFault: h3cRealtimeFaultList){
                if (null == h3cRealtimeFaultDao.findByFaultId(h3cRealtimeFault.getFaultId())){
                    h3cRealtimeFaultService.createOrUpdte(h3cRealtimeFault);
                }
            }
        }catch (Exception e){
            LOGGER.warn("sync {} event error!", JOB_NAME, e);
        }
        LOGGER.info("sync {} end.",JOB_NAME);
    }

    public H3cRealtimeFaultService getH3cRealtimeFaultService() {
        return h3cRealtimeFaultService;
    }

    public void setH3cRealtimeFaultService(H3cRealtimeFaultService h3cRealtimeFaultService) {
        this.h3cRealtimeFaultService = h3cRealtimeFaultService;
    }

    public JobEnv getJobEnv() {
        return jobEnv;
    }

    public void setJobEnv(JobEnv jobEnv) {
        this.jobEnv = jobEnv;
    }
}
