package com.uics.grab.repository;

import com.uics.grab.entity.VrvConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.util.List;

/**
 * vrv配置信息
* Created by tom on 2016-12-07 14:34:59.
 */
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml"})
public class VrvConfigDaoTest extends SpringTransactionalTestCase {

    @Autowired
    private VrvConfigDao vrvConfigDao;

    @Test
    public void findAll(){
        List<VrvConfig> vrvConfigs = vrvConfigDao.findAllBy();

        Assert.assertNotNull(vrvConfigs);

        Assert.assertEquals(vrvConfigs.size(), 0);
    }
}
