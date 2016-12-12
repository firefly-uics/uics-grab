package com.uics.grab.service;

import com.uics.grab.entity.IdcsTodo;
import org.dubbo.x.service.CURDService;

import java.util.List;

/**
 * idcs代办
* Created by tom on 2016-12-07 14:34:59.
 */
public interface IdcsTodoService extends CURDService<IdcsTodo> {
    /**
     * 解析 idcs todo 代办页面
     * @param html
     * @return
     */
    List<IdcsTodo> parse(String html);

}
