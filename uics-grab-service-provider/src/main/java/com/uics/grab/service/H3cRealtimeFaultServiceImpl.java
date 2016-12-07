package com.uics.grab.service;

import com.uics.grab.entity.H3cRealtimeFault;
import org.dubbo.x.repository.DaoBase;
import org.dubbo.x.service.CURDServiceBase;
import com.uics.grab.repository.H3cRealtimeFaultDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  h3c告警信息
* Created by tom on 2016-12-07 14:34:58.
 */
public class H3cRealtimeFaultServiceImpl extends CURDServiceBase<H3cRealtimeFault> implements H3cRealtimeFaultService {
    @Autowired
    private H3cRealtimeFaultDao h3cRealtimeFaultDao;

    @Override
    public DaoBase<H3cRealtimeFault> getDao() {
        return h3cRealtimeFaultDao;
    }
}
