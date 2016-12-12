package com.uics.grab.repository;

import com.uics.grab.entity.IdcsNotification;
import org.dubbo.x.repository.DaoBase;

/**
 * idcs通知
* Created by tom on 2016-12-07 10:53:06.
 **/
public interface IdcsNotificationDao extends DaoBase<IdcsNotification> {
    IdcsNotification findByNotificationId(String notificationId);
}
