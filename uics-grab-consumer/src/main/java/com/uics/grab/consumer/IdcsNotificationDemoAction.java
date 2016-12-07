package com.uics.grab.consumer;


import com.alibaba.fastjson.JSON;
import com.uics.grab.entity.IdcsNotification;
import com.uics.grab.service.IdcsNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
* Created by tom on 2016-12-07 10:53:06.
 */
public class IdcsNotificationDemoAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(IdcsNotificationDemoAction.class);
    private IdcsNotificationService idcsNotificationService;

    public IdcsNotificationService getIdcsNotificationService() {
        return idcsNotificationService;
    }

    public void setIdcsNotificationService(IdcsNotificationService idcsNotificationService) {
        this.idcsNotificationService = idcsNotificationService;
    }

    public void start() throws Exception {
        List<IdcsNotification> idcsNotifications = idcsNotificationService.listAll();
        assert(idcsNotifications != null);
        assert(idcsNotifications.size() == 1);

        LOGGER.info("list all:{}", JSON.toJSON(idcsNotifications));
    }
}
