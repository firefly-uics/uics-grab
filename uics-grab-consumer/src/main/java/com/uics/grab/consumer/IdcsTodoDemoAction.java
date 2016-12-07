package com.uics.grab.consumer;


import com.alibaba.fastjson.JSON;
import com.uics.grab.entity.IdcsTodo;
import com.uics.grab.service.IdcsTodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
* Created by tom on 2016-12-07 14:34:59.
 */
public class IdcsTodoDemoAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(IdcsTodoDemoAction.class);
    private IdcsTodoService idcsTodoService;

    public IdcsTodoService getIdcsTodoService() {
        return idcsTodoService;
    }

    public void setIdcsTodoService(IdcsTodoService idcsTodoService) {
        this.idcsTodoService = idcsTodoService;
    }

    public void start() throws Exception {
        List<IdcsTodo> idcsTodos = idcsTodoService.listAll();
        assert(idcsTodos != null);
        assert(idcsTodos.size() == 1);

        LOGGER.info("list all:{}", JSON.toJSON(idcsTodos));
    }
}
