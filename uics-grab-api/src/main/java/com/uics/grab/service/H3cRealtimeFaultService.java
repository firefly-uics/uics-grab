package com.uics.grab.service;

import com.uics.grab.entity.H3cRealtimeFault;
import org.dubbo.x.service.CURDService;

import java.util.List;

/**
 * h3c告警信息
* Created by tom on 2016-12-07 14:34:58.
 */
public interface H3cRealtimeFaultService extends CURDService<H3cRealtimeFault> {
    /**
     * 解析 h3c 告警页面
     * @param html
     * @return
     */
    List<H3cRealtimeFault> parse(String html);
}
