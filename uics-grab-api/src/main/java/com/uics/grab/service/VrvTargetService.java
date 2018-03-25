package com.uics.grab.service;

import com.uics.grab.entity.VrvConfig;
import com.uics.grab.entity.VrvTarget;
import org.dubbo.x.service.CURDService;

import java.util.List;

/**
 * vrv监控指标统计信息
* Created by tom on 2016-12-07 14:34:58.
 */
public interface VrvTargetService extends CURDService<VrvTarget> {

    VrvTarget findByConfigIdAndXmid(String id, int i);

    /**
     * 同步统计数据
     */
    List<VrvTarget> syncStatistics(VrvConfig vrvConfig);
}
