package com.uics.grab.facade;

import com.uics.grab.entity.IdcsTodo;
import org.dubbo.x.service.CURDService;
import org.dubbo.x.facade.RestServiceBase;
import com.uics.grab.service.IdcsTodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * idcs代办
* Created by tom on 2016-12-07 14:34:59.
 */
public class IdcsTodoRestServiceImpl extends RestServiceBase<IdcsTodo> implements IdcsTodoRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdcsTodoRestServiceImpl.class);

    private IdcsTodoService idcsTodoService;

    public IdcsTodoService getIdcsTodoService() {
        return idcsTodoService;
    }

    public void setIdcsTodoService(IdcsTodoService idcsTodoService) {
        this.idcsTodoService = idcsTodoService;
    }

    @Override
    public CURDService<IdcsTodo> getService() {
        return idcsTodoService;
    }

}
