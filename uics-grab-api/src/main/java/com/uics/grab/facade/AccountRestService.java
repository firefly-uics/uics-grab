package com.uics.grab.facade;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 账号
 *
 * @author baiqw
 */

@Path("accounts")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
public interface AccountRestService {
    /**
     * 注册
     * @param signUp
     * @return
     */
    @POST
    @Path("sign-up")
    RestResult signUp(SignUpVO signUp);

    /**
     * 登录
     * @param signIn
     * @return
     */
    @POST
    @Path("sign-in")
    RestResult signIn(SignInVO signIn);

}
