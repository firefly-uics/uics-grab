package com.uics.grab.service;

import com.uics.grab.entity.IdcsTodo;
import org.dubbo.x.repository.DaoBase;
import org.dubbo.x.service.CURDServiceBase;
import com.uics.grab.repository.IdcsTodoDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  idcs代办
* Created by tom on 2016-12-07 14:34:59.
 */
public class IdcsTodoServiceImpl extends CURDServiceBase<IdcsTodo> implements IdcsTodoService {
    @Autowired
    private IdcsTodoDao idcsTodoDao;

    @Override
    public DaoBase<IdcsTodo> getDao() {
        return idcsTodoDao;
    }
}
