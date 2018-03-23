package com.uics.grab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.dubbo.x.entity.IdEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * vrv监控指标统计信息
 * {"total":1,"rows":
 * [{"ID":1,"ClassName":"sdfsf","DeptName":"asfsadf","AlarmType":"sdfsdfsf","DeviceName":"sdfsf","IPAddress":"192.168.1.1","Status":"0","Dt":"2016-11-25T00:00:00"}]
 * }
 * <p>
* Created by tom on 2016-12-07 14:34:58.
 */
@ApiModel("vrv监控指标统计信息")
public class VrvAlarmHistory{

    /**
     * id
     */
    private String id;

    /**
     * 单位名称
     */
    private String className;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 告警类型
     */
    private String alarmType;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 状态
     */
    private String status;

    /**
     *
     */
    private String dt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "VrvAlarmHistory{" +
               "id='" + id + '\'' +
               ", className='" + className + '\'' +
               ", deptName='" + deptName + '\'' +
               ", alarmType='" + alarmType + '\'' +
               ", deviceName='" + deviceName + '\'' +
               ", ipAddress='" + ipAddress + '\'' +
               ", status='" + status + '\'' +
               ", dt='" + dt + '\'' +
               '}';
    }
}

