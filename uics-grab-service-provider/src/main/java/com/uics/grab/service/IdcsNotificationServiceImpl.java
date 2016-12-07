package com.uics.grab.service;

import com.uics.grab.entity.IdcsNotification;
import org.dubbo.x.repository.DaoBase;
import org.dubbo.x.service.CURDServiceBase;
import com.uics.grab.repository.IdcsNotificationDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  idcs通知
* Created by tom on 2016-12-07 10:53:06.
 */
public class IdcsNotificationServiceImpl extends CURDServiceBase<IdcsNotification> implements IdcsNotificationService {
    @Autowired
    private IdcsNotificationDao idcsNotificationDao;

    @Override
    public DaoBase<IdcsNotification> getDao() {
        return idcsNotificationDao;
    }
}
