package com.uics.grab.repository;

import com.uics.grab.entity.IdcsTodo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.util.List;

/**
 * idcs代办
* Created by tom on 2016-12-07 14:34:59.
 */
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml"})
public class IdcsTodoDaoTest extends SpringTransactionalTestCase {

    @Autowired
    private IdcsTodoDao idcsTodoDao;

    @Test
    public void findAll(){
        List<IdcsTodo> idcsTodos = idcsTodoDao.findAllBy();

        Assert.assertNotNull(idcsTodos);

        Assert.assertEquals(idcsTodos.size(), 0);
    }
}
