package com.uics.grab.job;

import com.uics.grab.entity.H3cRealtimeFault;
import com.uics.grab.entity.IdcsTodo;
import com.uics.grab.repository.H3cRealtimeFaultDao;
import com.uics.grab.repository.IdcsTodoDao;
import com.uics.grab.service.H3cRealtimeFaultService;
import com.uics.grab.service.IdcsTodoService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

/**
 * Created by tom on 16/8/18.
 */
public class IdcsJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(IdcsJob.class);

    private IdcsTodoService idcsTodoService;
    @Autowired
    private IdcsTodoDao idcsTodoDao;

    public void syncTodo(){
        LOGGER.info("sync idcs todo start...");
        try {
            List<IdcsTodo> idcsTodoList = idcsTodoService.parse(FileUtils.readFileToString(new File("/work/001_code/github/java/uics/uics-grab/uics-grab-service-provider/src/test/resources/third/idcs/代办.html")));
            for (IdcsTodo idcsTodo: idcsTodoList){
                if (null == idcsTodoDao.findByTodoId(idcsTodo.getTodoId())){
                    idcsTodoService.createOrUpdte(idcsTodo);
                }
            }
        }catch (Exception e){
            LOGGER.warn("sync idcs todo event error!", e);
        }
        LOGGER.info("sync idcs todo end.");
    }

    public IdcsTodoService getIdcsTodoService() {
        return idcsTodoService;
    }

    public void setIdcsTodoService(IdcsTodoService idcsTodoService) {
        this.idcsTodoService = idcsTodoService;
    }
}
