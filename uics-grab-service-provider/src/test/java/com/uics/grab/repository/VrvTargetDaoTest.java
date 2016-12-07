package com.uics.grab.repository;

import com.uics.grab.entity.VrvTarget;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.util.List;

/**
 * vrv监控指标统计信息
* Created by tom on 2016-12-07 14:34:58.
 */
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml"})
public class VrvTargetDaoTest extends SpringTransactionalTestCase {

    @Autowired
    private VrvTargetDao vrvTargetDao;

    @Test
    public void findAll(){
        List<VrvTarget> vrvTargets = vrvTargetDao.findAllBy();

        Assert.assertNotNull(vrvTargets);

        Assert.assertEquals(vrvTargets.size(), 0);
    }
}
