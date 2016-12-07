package com.uics.grab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.dubbo.x.entity.IdEntity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * vrv配置信息
 * <p>
* Created by tom on 2016-12-07 14:34:59.
 */
@Entity
@Table(name = "t_vrv_config")
@ApiModel("vrv配置信息")
public class VrvConfig extends IdEntity {
    
    /**
     * vrv服务器地址
     */
    @ApiModelProperty(value = "vrv服务器地址", required = false)
    @NotNull
    @Column(columnDefinition = "vrv服务器地址")
    private String ip;
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    /**
     * vrv服务器名称
     */
    @ApiModelProperty(value = "vrv服务器名称", required = false)
    @NotNull
    @Column(columnDefinition = "vrv服务器名称")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 刷新周期
     */
    @ApiModelProperty(value = "刷新周期", required = false)
    @NotNull
    @Column(columnDefinition = "刷新周期")
    private Integer cycle;
    public Integer getCycle() {
        return cycle;
    }
    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }
    
    /**
     * vrv服务器刷新时间
     */
    @ApiModelProperty(value = "vrv服务器刷新时间", required = false)
    @NotNull
    @Column(columnDefinition = "vrv服务器刷新时间")
    private Integer lastRefreshDate;
    public Integer getLastRefreshDate() {
        return lastRefreshDate;
    }
    public void setLastRefreshDate(Integer lastRefreshDate) {
        this.lastRefreshDate = lastRefreshDate;
    }
    
}

