package com.uics.grab.third.idcs;

import com.uics.grab.entity.IdcsNotification;
import com.uics.grab.entity.IdcsTodo;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tom on 16/12/12.
 */
public class ParseNotification {
    @Test
    public void parse() throws IOException {
        parse(FileUtils.readFileToString(new File("/work/001_code/github/java/uics/uics-grab/uics-grab-service-provider/src/test/resources/third/idcs/通知.html")));
    }

    public List<IdcsNotification> parse(String html){
        Document document = Jsoup.parse(html);
        List<IdcsNotification> idcsNotifications = new ArrayList<IdcsNotification>();

        Elements trs = document.select("#viewtable").select("tbody").select("tr");
        for (Element tr: trs){
            Elements tds = tr.select("td");

            String type = tds.get(1).text();
            if (StringUtils.isNotBlank(StringUtils.replace(type," ",""))){
                IdcsNotification idcsNotification = new IdcsNotification();

                idcsNotification.setNotificationType(type);
                idcsNotification.setTitle(tds.get(2).text());
                idcsNotification.setDateTime(tds.get(3).text());
                idcsNotification.setReleaseUnit(tds.get(4).text());
                idcsNotification.setValid(tds.get(5).text());
                idcsNotification.setLastRefreshDate(System.currentTimeMillis());
                idcsNotification.setNotificationId(tds.get(6).select("textarea:eq(0)").val());
                idcsNotifications.add(idcsNotification);

            }
        }

        return idcsNotifications;

    }
}
