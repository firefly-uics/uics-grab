package com.uics.grab.facade;

import org.dubbo.x.facade.CURDRestService;
import org.dubbo.x.facade.RestResult;
import org.dubbo.x.util.ConstantVariable;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.uics.grab.entity.VrvConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * vrv配置信息 接口
 *
* Created by tom on 2016-12-07 14:34:59.
 */

@Path("vrvconfigs")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Api(value="vrvconfigs", description = "vrv配置信息接口")
public interface VrvConfigRestService extends CURDRestService<VrvConfig>{
    /**
     * vrv配置信息
     * @return
     */
    @GET
    @Path("")
    @ApiOperation(value = "vrv配置信息",
            notes = "vrv配置信息列表.")
    RestResult<List<VrvConfig>> list(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token);

    /**
     * vrv配置信息 详细信息
     *
     * @return
     */
    @GET
    @Path("/{id}")
    @ApiOperation(value = "详细信息",
            notes = "vrv配置信息详细信息.")
    RestResult<VrvConfig> detail(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("id") @PathParam("id") String uuid);

    @POST
    @Path("")
    @ApiOperation(value = "添加/修改vrv配置信息", notes = "添加/修改vrv配置信息")
    RestResult<VrvConfig> create(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token,VrvConfig vrvConfig);

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "删除vrv配置信息", notes = "删除vrv配置信息")
    RestResult<String> delete(@HeaderParam(ConstantVariable.HEADER_AUTHORIZATION_KEY) String token, @ApiParam("id") @PathParam("id") String uuid);
}
