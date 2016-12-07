package com.uics.grab.facade;

import com.uics.grab.entity.IdcsNotification;
import org.dubbo.x.service.CURDService;
import org.dubbo.x.facade.RestServiceBase;
import com.uics.grab.service.IdcsNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * idcs通知
* Created by tom on 2016-12-07 10:53:06.
 */
public class IdcsNotificationRestServiceImpl extends RestServiceBase<IdcsNotification> implements IdcsNotificationRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdcsNotificationRestServiceImpl.class);

    private IdcsNotificationService idcsNotificationService;

    public IdcsNotificationService getIdcsNotificationService() {
        return idcsNotificationService;
    }

    public void setIdcsNotificationService(IdcsNotificationService idcsNotificationService) {
        this.idcsNotificationService = idcsNotificationService;
    }

    @Override
    public CURDService<IdcsNotification> getService() {
        return idcsNotificationService;
    }

}
