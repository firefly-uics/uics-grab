package com.uics.grab.job;

import com.uics.grab.entity.H3cRealtimeFault;
import com.uics.grab.entity.IdcsNotification;
import com.uics.grab.entity.IdcsTodo;
import com.uics.grab.repository.H3cRealtimeFaultDao;
import com.uics.grab.repository.IdcsNotificationDao;
import com.uics.grab.repository.IdcsTodoDao;
import com.uics.grab.service.H3cRealtimeFaultService;
import com.uics.grab.service.IdcsNotificationService;
import com.uics.grab.service.IdcsTodoService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

/**
 * Created by tom on 16/8/18.
 */
public class IdcsJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(IdcsJob.class);
    private static final String JOB_NAME = "idcs";

    private IdcsTodoService idcsTodoService;
    private IdcsNotificationService idcsNotificationService;
    private JobEnv jobEnv;

    @Autowired
    private IdcsTodoDao idcsTodoDao;
    @Autowired
    private IdcsNotificationDao idcsNotificationDao;

    public void syncTodo(){
        LOGGER.info("sync {} todo start...",JOB_NAME);
        try {
            File file = new File(jobEnv.getProperty("temp.directory") + File.separator + jobEnv.getProperty("idcs.temp.dir.name") + File.separator + jobEnv.getProperty("idcs.temp.file.todo.name"));

            List<IdcsTodo> idcsTodoList = idcsTodoService.parse(FileUtils.readFileToString(file));
            for (IdcsTodo idcsTodo: idcsTodoList){
                if (null == idcsTodoDao.findByTodoId(idcsTodo.getTodoId())){
                    idcsTodoService.createOrUpdte(idcsTodo);
                }
            }
        }catch (Exception e){
            LOGGER.warn("sync {} todo event error!", JOB_NAME,e);
        }
        LOGGER.info("sync {} todo end.",JOB_NAME);
    }

    public void syncNotification(){
        LOGGER.info("sync {} Notification start...",JOB_NAME);
        try {
            File file = new File(jobEnv.getProperty("temp.directory") + File.separator + jobEnv.getProperty("idcs.temp.dir.name") + File.separator + jobEnv.getProperty("idcs.temp.file.notification.name"));
            List<IdcsNotification> idcsNotificationList = idcsNotificationService.parse(FileUtils.readFileToString(file));
            for (IdcsNotification idcsNotification: idcsNotificationList){
                if (null == idcsNotificationDao.findByNotificationId(idcsNotification.getNotificationId())){
                    idcsNotificationService.createOrUpdte(idcsNotification);
                }
            }
        }catch (Exception e){
            LOGGER.warn("sync {} Notification event error!", JOB_NAME, e);
        }
        LOGGER.info("sync {} Notification end.",JOB_NAME);
    }

    public IdcsTodoService getIdcsTodoService() {
        return idcsTodoService;
    }

    public void setIdcsTodoService(IdcsTodoService idcsTodoService) {
        this.idcsTodoService = idcsTodoService;
    }

    public IdcsNotificationService getIdcsNotificationService() {
        return idcsNotificationService;
    }

    public void setIdcsNotificationService(IdcsNotificationService idcsNotificationService) {
        this.idcsNotificationService = idcsNotificationService;
    }

    public JobEnv getJobEnv() {
        return jobEnv;
    }

    public void setJobEnv(JobEnv jobEnv) {
        this.jobEnv = jobEnv;
    }
}
