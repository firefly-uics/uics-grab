package com.uics.grab.facade;

import org.dubbo.x.facade.CURDRestService;
import org.dubbo.x.facade.RestResult;
import org.dubbo.x.util.ConstantVariable;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.uics.grab.entity.H3cRealtimeFault;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * h3c告警信息 接口
 *
* Created by tom on 2016-12-07 14:34:58.
 */

@Path("h3crealtimefaults")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Api(value="h3crealtimefaults", description = "h3c告警信息接口")
public interface H3cRealtimeFaultRestService extends CURDRestService<H3cRealtimeFault>{
    /**
     * h3c告警信息
     * @return
     */
    @GET
    @Path("")
    @ApiOperation(value = "h3c告警信息",
            notes = "h3c告警信息列表.")
    RestResult<List<H3cRealtimeFault>> list(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token);

    /**
     * h3c告警信息 详细信息
     *
     * @return
     */
    @GET
    @Path("/{id}")
    @ApiOperation(value = "详细信息",
            notes = "h3c告警信息详细信息.")
    RestResult<H3cRealtimeFault> detail(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("id") @PathParam("id") String uuid);

    @POST
    @Path("")
    @ApiOperation(value = "添加/修改h3c告警信息", notes = "添加/修改h3c告警信息")
    RestResult<H3cRealtimeFault> create(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token,H3cRealtimeFault h3cRealtimeFault);

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "删除h3c告警信息", notes = "删除h3c告警信息")
    RestResult<String> delete(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("id") @PathParam("id") String uuid);
}
