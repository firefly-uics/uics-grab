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
 * idcs通知
 * <p>
* Created by tom on 2016-12-07 10:53:05.
 */
@Entity
@Table(name = "t_idcs_notification")
@ApiModel("idcs通知")
public class IdcsNotification extends IdEntity {
    
    /**
     * 通知id
     */
    @ApiModelProperty(value = "通知id", required = false)
    @NotNull
    @Column(columnDefinition = "通知id")
    private String notificationId;
    public String getNotificationId() {
        return notificationId;
    }
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }
    
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", required = false)
    
    @Column(columnDefinition = "类型")
    private String notificationType;
    public String getNotificationType() {
        return notificationType;
    }
    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
    
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题", required = false)
    
    @Column(columnDefinition = "标题")
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间", required = false)
    
    @Column(columnDefinition = "发布时间")
    private String dateTime;
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    /**
     * 发布单位
     */
    @ApiModelProperty(value = "发布单位", required = false)
    
    @Column(columnDefinition = "发布单位")
    private String releaseUnit;
    public String getReleaseUnit() {
        return releaseUnit;
    }
    public void setReleaseUnit(String releaseUnit) {
        this.releaseUnit = releaseUnit;
    }
    
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效", required = false)
    
    @Column(columnDefinition = "是否有效")
    private String valid;
    public String getValid() {
        return valid;
    }
    public void setValid(String valid) {
        this.valid = valid;
    }
    
    /**
     * 刷新时间
     */
    @ApiModelProperty(value = "刷新时间", required = false)
    @NotNull
    @Column(columnDefinition = "刷新时间")
    private Long lastRefreshDate;
    public Long getLastRefreshDate() {
        return lastRefreshDate;
    }
    public void setLastRefreshDate(Long lastRefreshDate) {
        this.lastRefreshDate = lastRefreshDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

