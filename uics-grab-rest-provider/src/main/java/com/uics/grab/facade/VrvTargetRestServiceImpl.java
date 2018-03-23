package com.uics.grab.facade;

import com.alibaba.fastjson.JSON;
import com.uics.grab.entity.VrvAlarmHistory;
import com.uics.grab.entity.VrvPage;
import com.uics.grab.entity.VrvTarget;
import io.swagger.annotations.ApiParam;
import org.dubbo.x.facade.*;
import org.dubbo.x.facade.RestResult;
import org.dubbo.x.service.CURDService;
import com.uics.grab.service.VrvTargetService;
import org.dubbo.x.util.ConstantVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.ws.rs.HeaderParam;

/**
 * vrv监控指标统计信息
* Created by tom on 2016-12-07 14:34:58.
 */
public class VrvTargetRestServiceImpl extends RestServiceBase<VrvTarget> implements VrvTargetRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VrvTargetRestServiceImpl.class);

    private VrvTargetService vrvTargetService;

    public VrvTargetService getVrvTargetService() {
        return vrvTargetService;
    }

    public void setVrvTargetService(VrvTargetService vrvTargetService) {
        this.vrvTargetService = vrvTargetService;
    }

    @Override
    public CURDService<VrvTarget> getService() {
        return vrvTargetService;
    }

    @Override
    public RestResult<List<VrvAlarmHistory>> alarmHistory(
            @HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token,
            @ApiParam("type") String type, @ApiParam("begintime") String begintime,
            @ApiParam("endtime") String endtime) {
        String json = "{\"total\":1,\"rows\":\n"
                      + "        [{\"ID\":1,\"ClassName\":\"sdfsf\",\"DeptName\":\"asfsadf\",\"AlarmType\":\"sdfsdfsf\",\"DeviceName\":\"sdfsf\",\"IPAddress\":\"192.168.1.1\",\"Status\":\"0\",\"Dt\":\"2016-11-25T00:00:00\"}]\n"
                      + "    }";

        VrvPage vrvPage = JSON.parseObject(json, VrvPage.class);

        return RestResult.OK(vrvPage.getRows());
    }
}
