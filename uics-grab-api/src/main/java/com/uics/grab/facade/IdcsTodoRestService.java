package com.uics.grab.facade;

import org.dubbo.x.facade.CURDRestService;
import org.dubbo.x.facade.RestResult;
import org.dubbo.x.util.ConstantVariable;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.uics.grab.entity.IdcsTodo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * idcs代办 接口
 *
* Created by tom on 2016-12-07 14:34:59.
 */

@Path("idcstodos")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Api(value="idcstodos", description = "idcs代办接口")
public interface IdcsTodoRestService extends CURDRestService<IdcsTodo>{
    /**
     * idcs代办
     * @return
     */
    @GET
    @Path("")
    @ApiOperation(value = "idcs代办",
            notes = "idcs代办列表.")
    RestResult<List<IdcsTodo>> list(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token);

    /**
     * idcs代办 详细信息
     *
     * @return
     */
    @GET
    @Path("/{id}")
    @ApiOperation(value = "详细信息",
            notes = "idcs代办详细信息.")
    RestResult<IdcsTodo> detail(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("id") @PathParam("id") String uuid);

    @POST
    @Path("")
    @ApiOperation(value = "添加/修改idcs代办", notes = "添加/修改idcs代办")
    RestResult<IdcsTodo> create(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token,IdcsTodo idcsTodo);

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "删除idcs代办", notes = "删除idcs代办")
    RestResult<String> delete(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("id") @PathParam("id") String uuid);
}
