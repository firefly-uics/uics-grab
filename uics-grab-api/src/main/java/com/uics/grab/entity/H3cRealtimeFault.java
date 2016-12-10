package com.uics.grab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dubbo.x.entity.IdEntity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * h3c告警信息
 * <p>
* Created by tom on 2016-12-07 14:34:57.
 */
@Entity
@Table(name = "t_h3c_realtime_fault")
@ApiModel("h3c告警信息")
public class H3cRealtimeFault extends IdEntity {
    
    /**
     * 告警id
     */
    @ApiModelProperty(value = "告警id", required = false)
    @NotNull
    @Column(columnDefinition = "告警id")
    private String faultId;
    public String getFaultId() {
        return faultId;
    }
    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }
    
    /**
     * 级别
     */
    @ApiModelProperty(value = "级别", required = false)
    
    @Column(columnDefinition = "级别")
    private String level;
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    
    /**
     * 源
     */
    @ApiModelProperty(value = "源", required = false)
    
    @Column(columnDefinition = "源")
    private String source;
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", required = false)
    
    @Column(columnDefinition = "类型")
    private String faultType;
    public String getFaultType() {
        return faultType;
    }
    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }
    
    /**
     * 信息
     */
    @ApiModelProperty(value = "信息", required = false)
    
    @Column(columnDefinition = "信息")
    private String info;
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    
    /**
     * 时间
     */
    @ApiModelProperty(value = "时间", required = false)
    
    @Column(columnDefinition = "时间")
    private String dateTime;
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    /**
     * 分析报告
     */
    @ApiModelProperty(value = "分析报告", required = false)
    
    @Column(columnDefinition = "分析报告")
    private String analyseReport;
    public String getAnalyseReport() {
        return analyseReport;
    }
    public void setAnalyseReport(String analyseReport) {
        this.analyseReport = analyseReport;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

