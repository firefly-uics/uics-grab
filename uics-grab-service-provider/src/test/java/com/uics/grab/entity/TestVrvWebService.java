package com.uics.grab.entity;

import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.junit.Test;

import javax.xml.namespace.QName;
/**
 * Created by tom on 2018/3/23.
 */
public class TestVrvWebService {

    @Test
    public void testJsonToObject(){
        String url = "https://10.234.156.8/jbjk/WebService/SecurityWebService.asmx?wsdl";
        String method = "GetStatistics";
        Object[] parameters = null;
        System.out.println(invokeRemoteMethod(url, method, parameters)[0]);
    }

    public static Object[] invokeRemoteMethod(String url, String operation, Object[] parameters){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        if (!url.endsWith("wsdl")) {
            url += "?wsdl";
        }
        org.apache.cxf.endpoint.Client client = dcf.createClient(url);
        //处理webService接口和实现类namespace不同的情况，CXF动态客户端在处理此问题时，会报No operation was found with the name的异常
        Endpoint endpoint = client.getEndpoint();
        QName opName = new QName(endpoint.getService().getName().getNamespaceURI(),operation);
        BindingInfo bindingInfo= endpoint.getEndpointInfo().getBinding();
        if(bindingInfo.getOperation(opName) == null){
            for(BindingOperationInfo operationInfo : bindingInfo.getOperations()){
                if(operation.equals(operationInfo.getName().getLocalPart())){
                    opName = operationInfo.getName();
                    break;
                }
            }
        }
        Object[] res = null;
        try {
            if (null == parameters){
                res = client.invoke(opName);
            }else {
                res = client.invoke(opName, parameters);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
