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
import javax.ws.rs.QueryParam;

/**
 * vrv监控指标统计信息
* Created by tom on 2016-12-07 14:34:58.
 */
public class VrvTargetRestServiceImpl extends RestServiceBase<VrvTarget> implements VrvTargetRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VrvTargetRestServiceImpl.class);

    private VrvTargetService vrvTargetService;
    private Logger logger = LoggerFactory.getLogger(VrvTargetRestServiceImpl.class);

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
            @HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("area") String area,
            @ApiParam("type") String type, @ApiParam("begintime") String begintime,
            @ApiParam("endtime") String endtime) {
        String json = "{\"total\":1,\"rows\":\n"
                      + "        ["
                      + "{\"ID\":1,\"ClassName\":\"吉安供电公司\",\"DeptName\":\"吉安店里实业总公司\",\"AlarmType\":\"发现弱口令设备\",\"DeviceName\":\"郭德伟\",\"IPAddress\":\"10.234.157.78\",\"Status\":\"1\",\"Dt\":\"2018-03-14T08:50:92\"},"
                      + "{\"ID\":2,\"ClassName\":\"客户服务中心\",\"DeptName\":\"运检部-配电运检室\",\"AlarmType\":\"发现弱口令设备\",\"DeviceName\":\"XT-20170821TJZ\",\"IPAddress\":\"10.234.159.97\",\"Status\":\"0\",\"Dt\":\"2018-03-09T09:10:84\"}"
                      + "]\n"
                      + "    }";
        if ("1".equals(area)){
            json = "{\"total\":1,\"rows\":\n"
                   + "        ["
                   + "{\"ID\":1,\"ClassName\":\"变电检修分公司\",\"DeptName\":\"运维部-变电检修一班\",\"AlarmType\":\"发现弱口令设备\",\"DeviceName\":\"变电检修一班\",\"IPAddress\":\"10.234.147.38\",\"Status\":\"1\",\"Dt\":\"2018-03-14T11:31:92\"},"
                   + "{\"ID\":2,\"ClassName\":\"客户服务中心\",\"DeptName\":\"运检部-配电运检室\",\"AlarmType\":\"发现弱口令设备\",\"DeviceName\":\"13F运检\",\"IPAddress\":\"10.234.158.68\",\"Status\":\"0\",\"Dt\":\"2018-01-12T10:05:84\"}"
                   + "]\n"
                   + "    }";
        }
        try {
            json = vrvTargetService.alarmHistory(area, type, begintime, endtime);
        }catch (Exception e){
            logger.warn("alarmHistory", e);

        }

        VrvPage vrvPage = JSON.parseObject(json, VrvPage.class);

        return RestResult.OK(vrvPage.getRows());
    }
}
