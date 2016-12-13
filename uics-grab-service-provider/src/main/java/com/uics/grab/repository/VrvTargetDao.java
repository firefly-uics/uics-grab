package com.uics.grab.repository;

import com.uics.grab.entity.VrvTarget;
import org.dubbo.x.repository.DaoBase;

/**
 * vrv监控指标统计信息
* Created by tom on 2016-12-07 14:34:58.
 **/
public interface VrvTargetDao extends DaoBase<VrvTarget> {
    VrvTarget findByConfigIdAndXmid(String id, int i);
}
