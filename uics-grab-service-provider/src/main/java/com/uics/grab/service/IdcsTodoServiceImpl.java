package com.uics.grab.service;

import com.uics.grab.entity.IdcsTodo;
import org.apache.commons.lang.StringUtils;
import org.dubbo.x.repository.DaoBase;
import org.dubbo.x.service.CURDServiceBase;
import com.uics.grab.repository.IdcsTodoDao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *  idcs代办
* Created by tom on 2016-12-07 14:34:59.
 */
public class IdcsTodoServiceImpl extends CURDServiceBase<IdcsTodo> implements IdcsTodoService {
    @Autowired
    private IdcsTodoDao idcsTodoDao;

    @Override
    public DaoBase<IdcsTodo> getDao() {
        return idcsTodoDao;
    }

    @Override
    public List<IdcsTodo> parse(String html) {
        Document document = Jsoup.parse(html);
        List<IdcsTodo> idcsTodos = new ArrayList<IdcsTodo>();

        Elements trs = document.select("#viewtable").select("tbody").select("tr");
        for (Element tr: trs){
            Elements tds = tr.select("td");

            String title = tds.get(1).text();
            if (StringUtils.isNotBlank(StringUtils.replace(title," ",""))){
                IdcsTodo idcsTodo = new IdcsTodo();

                idcsTodo.setTitle(title);
                idcsTodo.setTodoType(tds.get(2).text());
                idcsTodo.setTodoId(tds.get(3).select("textarea").val());
                idcsTodo.setLastRefreshDate(System.currentTimeMillis());

                idcsTodos.add(idcsTodo);
            }
        }

        return idcsTodos;
    }
}
