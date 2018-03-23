package com.uics.grab.entity;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * vrv监控指标统计信息
 * {"total":1,"rows":
 * [{"ID":1,"ClassName":"sdfsf","DeptName":"asfsadf","AlarmType":"sdfsdfsf","DeviceName":"sdfsf","IPAddress":"192.168.1.1","Status":"0","Dt":"2016-11-25T00:00:00"}]
 * }
 * <p>
* Created by tom on 2016-12-07 14:34:58.
 */
@ApiModel("vrv监控指标统计信息")
public class VrvPage {
    private int total;
    private List<VrvAlarmHistory> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<VrvAlarmHistory> getRows() {
        return rows;
    }

    public void setRows(List<VrvAlarmHistory> rows) {
        this.rows = rows;
    }
}

