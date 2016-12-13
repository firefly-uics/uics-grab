package com.uics.grab.job;

import com.uics.grab.entity.IdcsNotification;
import com.uics.grab.entity.IdcsTodo;
import com.uics.grab.entity.VrvConfig;
import com.uics.grab.entity.VrvTarget;
import com.uics.grab.repository.IdcsNotificationDao;
import com.uics.grab.repository.IdcsTodoDao;
import com.uics.grab.service.IdcsNotificationService;
import com.uics.grab.service.IdcsTodoService;
import com.uics.grab.service.VrvConfigService;
import com.uics.grab.service.VrvTargetService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

/**
 * Created by tom on 16/8/18.
 */
public class VrvJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(VrvJob.class);
    private static final String JOB_NAME = "vrv";

    private VrvConfigService vrvConfigService;
    private VrvTargetService vrvTargetService;


    public void sync(){
        LOGGER.info("sync {} start...", JOB_NAME);

        List<VrvConfig> vrvConfigs = vrvConfigService.listAll();
        for (VrvConfig vrvConfig: vrvConfigs) {
            try {
                VrvTarget vrvTarget = vrvTargetService.findByConfigIdAndXmid(vrvConfig.getId(), 1);
                if (null == vrvTarget){
                    vrvTarget = new VrvTarget();
                }
                vrvTarget.setConfigId(vrvConfig.getId());
                vrvTarget.setSl(RandomUtils.nextInt(20, 30));
                vrvTarget.setXmmc("非法外链");
                vrvTarget.setXmid(1);

                vrvTargetService.createOrUpdte(vrvTarget);
            } catch (Exception e) {
                LOGGER.warn("sync {} event error!", JOB_NAME, e);
            }
        }
        LOGGER.info("sync {} end.", JOB_NAME);
    }

    public VrvConfigService getVrvConfigService() {
        return vrvConfigService;
    }

    public void setVrvConfigService(VrvConfigService vrvConfigService) {
        this.vrvConfigService = vrvConfigService;
    }

    public VrvTargetService getVrvTargetService() {
        return vrvTargetService;
    }

    public void setVrvTargetService(VrvTargetService vrvTargetService) {
        this.vrvTargetService = vrvTargetService;
    }
}
