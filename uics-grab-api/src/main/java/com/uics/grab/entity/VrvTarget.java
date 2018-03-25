package com.uics.grab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.dubbo.x.entity.IdEntity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * vrv监控指标统计信息
 * <p>
* Created by tom on 2016-12-07 14:34:58.
 */
@Entity
@Table(name = "t_vrv_target")
@ApiModel("vrv监控指标统计信息")
public class VrvTarget extends IdEntity {
    
    /**
     * vrv服务器配置信息
     */
    @ApiModelProperty(value = "vrv服务器配置信息", required = false)
    @NotNull
    @Column(columnDefinition = "vrv服务器配置信息")
    public VrvConfig config;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="config_id")
    public VrvConfig getConfig() {
        return config;
    }

    public void setConfig(VrvConfig config) {
        this.config = config;
    }

    /**
     * vrv监控指标统计结果
     */
    @ApiModelProperty(value = "vrv监控指标统计结果", required = false)
    @NotNull
    @Column(columnDefinition = "vrv监控指标统计结果")
    private Integer sl;
    public Integer getSl() {
        return sl;
    }
    public void setSl(Integer sl) {
        this.sl = sl;
    }
    
    /**
     * vrv监控指标id
     */
    @ApiModelProperty(value = "vrv监控指标id", required = false)
    @NotNull
    @Column(columnDefinition = "vrv监控指标id")
    private Integer xmid;
    public Integer getXmid() {
        return xmid;
    }
    public void setXmid(Integer xmid) {
        this.xmid = xmid;
    }
    
    /**
     * vrv监控指标名称
     */
    @ApiModelProperty(value = "vrv监控指标名称", required = false)
    
    @Column(columnDefinition = "vrv监控指标名称")
    private String xmmc;
    public String getXmmc() {
        return xmmc;
    }
    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    @Override
    public String toString() {
        return "VrvTarget{" +
               "sl=" + sl +
               ", xmid=" + xmid +
               ", xmmc='" + xmmc + '\'' +
               '}';
    }
}

