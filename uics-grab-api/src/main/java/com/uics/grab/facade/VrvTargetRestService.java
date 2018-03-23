package com.uics.grab.facade;

import com.uics.grab.entity.VrvAlarmHistory;
import org.dubbo.x.facade.CURDRestService;
import org.dubbo.x.facade.RestResult;
import org.dubbo.x.util.ConstantVariable;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.uics.grab.entity.VrvTarget;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * vrv监控指标统计信息 接口
 *
* Created by tom on 2016-12-07 14:34:58.
 */

@Path("vrvtargets")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Api(value="vrvtargets", description = "vrv监控指标统计信息接口")
public interface VrvTargetRestService extends CURDRestService<VrvTarget>{
    /**
     * vrv监控指标统计信息
     * @return
     */
    @GET
    @Path("")
    @ApiOperation(value = "vrv监控指标统计信息",
            notes = "vrv监控指标统计信息列表.")
    RestResult<List<VrvTarget>> list(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token);

    /**
     * vrv监控指标违规事件列表
     * @return
     */
    @GET
    @Path("/alarm/history")
    @ApiOperation(value = "vrv监控指标违规事件列表",
            notes = "vrv监控指标违规事件列表.")
    RestResult<List<VrvAlarmHistory>> alarmHistory(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("type") @QueryParam("type") String type, @ApiParam("begintime") @QueryParam("begintime") String begintime, @ApiParam("endtime") @QueryParam("endtime") String endtime);

    /**
     * vrv监控指标统计信息 详细信息
     *
     * @return
     */
    @GET
    @Path("/{id}")
    @ApiOperation(value = "详细信息",
            notes = "vrv监控指标统计信息详细信息.")
    RestResult<VrvTarget> detail(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("id") @PathParam("id") String uuid);

    @POST
    @Path("")
    @ApiOperation(value = "添加/修改vrv监控指标统计信息", notes = "添加/修改vrv监控指标统计信息")
    RestResult<VrvTarget> create(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token,VrvTarget vrvTarget);

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "删除vrv监控指标统计信息", notes = "删除vrv监控指标统计信息")
    RestResult<String> delete(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("id") @PathParam("id") String uuid);
}
