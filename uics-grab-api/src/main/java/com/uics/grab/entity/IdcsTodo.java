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
 * idcs代办
 * <p>
* Created by tom on 2016-12-07 14:34:59.
 */
@Entity
@Table(name = "t_idcs_todo")
@ApiModel("idcs代办")
public class IdcsTodo extends IdEntity {
    
    /**
     * 代办id
     */
    @ApiModelProperty(value = "代办id", required = false)
    @NotNull
    @Column(columnDefinition = "代办id")
    private String todoId;
    public String getTodoId() {
        return todoId;
    }
    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }
    
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", required = false)
    
    @Column(columnDefinition = "类型")
    private String todoType;
    public String getTodoType() {
        return todoType;
    }
    public void setTodoType(String todoType) {
        this.todoType = todoType;
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
     * 刷新时间
     */
    @ApiModelProperty(value = "刷新时间", required = false)
    @NotNull
    @Column(columnDefinition = "刷新时间")
    private Integer lastRefreshDate;
    public Integer getLastRefreshDate() {
        return lastRefreshDate;
    }
    public void setLastRefreshDate(Integer lastRefreshDate) {
        this.lastRefreshDate = lastRefreshDate;
    }
    
}

