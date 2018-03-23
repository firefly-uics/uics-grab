package com.uics.grab.entity;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Created by tom on 2018/3/23.
 */
public class TestVrvAlarmHistory {

    @Test
    public void testJsonToObject(){
        String json = "{\"total\":1,\"rows\":\n"
                      + "        [{\"ID\":1,\"ClassName\":\"sdfsf\",\"DeptName\":\"asfsadf\",\"AlarmType\":\"sdfsdfsf\",\"DeviceName\":\"sdfsf\",\"IPAddress\":\"192.168.1.1\",\"Status\":\"0\",\"Dt\":\"2016-11-25T00:00:00\"}]\n"
                      + "    }";


        VrvPage vrvPage = JSON.parseObject(json, VrvPage.class);

        System.out.println(vrvPage.getRows().get(0));
    }
}
