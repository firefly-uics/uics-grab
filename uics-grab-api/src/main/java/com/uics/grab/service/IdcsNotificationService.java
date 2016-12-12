package com.uics.grab.service;

import com.uics.grab.entity.IdcsNotification;
import com.uics.grab.entity.IdcsTodo;
import org.dubbo.x.service.CURDService;

import java.util.List;

/**
 * idcs通知
* Created by tom on 2016-12-07 10:53:06.
 */
public interface IdcsNotificationService extends CURDService<IdcsNotification> {
    /**
     * 解析 idcs 通知页面
     * @param html
     * @return
     */
    List<IdcsNotification> parse(String html);
}
