package com.uics.grab.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author baiqw
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class From implements Serializable {
    /**
     * 标示
     */
    private String agentId;
    /**
     *  名称
     */
    private String agentName;
    /**
     * 类型
     */
    private String agentType;
    /**
     * 系统版本
     */
    private String osVersion;
    /**
     * 位置信息
     */
    private String location;
    /**
     * 客户端版本
     */
    private String clientVersion;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    @Override
    public String toString() {
        return "From{" +
                "agentId='" + agentId + '\'' +
                ", agentName='" + agentName + '\'' +
                ", agentType='" + agentType + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", location='" + location + '\'' +
                ", clientVersion='" + clientVersion + '\'' +
                '}';
    }
}
