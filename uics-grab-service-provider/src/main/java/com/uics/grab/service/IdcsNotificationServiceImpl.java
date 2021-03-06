package com.uics.grab.service;

import com.uics.grab.entity.IdcsNotification;
import org.apache.commons.lang.StringUtils;
import org.dubbo.x.repository.DaoBase;
import org.dubbo.x.service.CURDServiceBase;
import com.uics.grab.repository.IdcsNotificationDao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *  idcs通知
* Created by tom on 2016-12-07 10:53:06.
 */
public class IdcsNotificationServiceImpl extends CURDServiceBase<IdcsNotification> implements IdcsNotificationService {
    @Autowired
    private IdcsNotificationDao idcsNotificationDao;

    @Override
    public DaoBase<IdcsNotification> getDao() {
        return idcsNotificationDao;
    }

    @Override
    public List<IdcsNotification> parse(String html) {
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
