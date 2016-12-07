package com.uics.grab.facade;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * DTO to customize the returned message
 *
 * @author lishen
 */
@XmlRootElement
public class RestResult implements Serializable {
    public static final int OK = 0;
    public static final String M_OK = "成功";

    public static RestResult OK(Object data){
        RestResult restResult = new RestResult();
        restResult.setErrorMessage(M_OK);
        restResult.setErrorCode(OK);
        restResult.setData(data);
        return restResult;
    }

    private int errorCode;
    private String errorMessage;
    private Object data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
