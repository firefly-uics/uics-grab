package com.uics.grab.facade;

import org.dubbo.x.facade.CURDRestService;
import org.dubbo.x.facade.RestResult;
import org.dubbo.x.util.ConstantVariable;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.uics.grab.entity.IdcsNotification;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * idcs通知 接口
 *
* Created by tom on 2016-12-07 10:53:06.
 */

@Path("idcsnotifications")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Api(value="idcsnotifications", description = "idcs通知接口")
public interface IdcsNotificationRestService extends CURDRestService<IdcsNotification>{
    /**
     * idcs通知
     * @return
     */
    @GET
    @Path("")
    @ApiOperation(value = "idcs通知",
            notes = "idcs通知列表.")
    RestResult<List<IdcsNotification>> list(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token);

    /**
     * idcs通知 详细信息
     *
     * @return
     */
    @GET
    @Path("/{id}")
    @ApiOperation(value = "详细信息",
            notes = "idcs通知详细信息.")
    RestResult<IdcsNotification> detail(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("id") @PathParam("id") String uuid);

    @POST
    @Path("")
    @ApiOperation(value = "添加/修改idcs通知", notes = "添加/修改idcs通知")
    RestResult<IdcsNotification> create(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token,IdcsNotification idcsNotification);

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "删除idcs通知", notes = "删除idcs通知")
    RestResult<String> delete(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("id") @PathParam("id") String uuid);
}
