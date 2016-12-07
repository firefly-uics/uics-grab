package com.uics.grab.repository;

import com.uics.grab.entity.H3cRealtimeFault;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.util.List;

/**
 * h3c告警信息
* Created by tom on 2016-12-07 14:34:58.
 */
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml"})
public class H3cRealtimeFaultDaoTest extends SpringTransactionalTestCase {

    @Autowired
    private H3cRealtimeFaultDao h3cRealtimeFaultDao;

    @Test
    public void findAll(){
        List<H3cRealtimeFault> h3cRealtimeFaults = h3cRealtimeFaultDao.findAllBy();

        Assert.assertNotNull(h3cRealtimeFaults);

        Assert.assertEquals(h3cRealtimeFaults.size(), 0);
    }
}
