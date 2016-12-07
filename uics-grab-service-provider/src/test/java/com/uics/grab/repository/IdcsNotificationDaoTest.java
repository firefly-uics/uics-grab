package com.uics.grab.repository;

import com.uics.grab.entity.IdcsNotification;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.util.List;

/**
 * idcs通知
* Created by tom on 2016-12-07 10:58:53.
 */
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml"})
public class IdcsNotificationDaoTest extends SpringTransactionalTestCase {

    @Autowired
    private IdcsNotificationDao idcsNotificationDao;

    @Test
    public void findAll(){
        List<IdcsNotification> idcsNotifications = idcsNotificationDao.findAllBy();

        Assert.assertNotNull(idcsNotifications);

        Assert.assertEquals(idcsNotifications.size(), 0);
    }
}
