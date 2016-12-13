package com.uics.grab.service;

import com.uics.grab.entity.VrvTarget;
import org.dubbo.x.repository.DaoBase;
import org.dubbo.x.service.CURDServiceBase;
import com.uics.grab.repository.VrvTargetDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  vrv监控指标统计信息
* Created by tom on 2016-12-07 14:34:58.
 */
public class VrvTargetServiceImpl extends CURDServiceBase<VrvTarget> implements VrvTargetService {
    @Autowired
    private VrvTargetDao vrvTargetDao;

    @Override
    public DaoBase<VrvTarget> getDao() {
        return vrvTargetDao;
    }

    @Override
    public VrvTarget findByConfigIdAndXmid(String id, int i) {
        return vrvTargetDao.findByConfigIdAndXmid(id, i);
    }
}
