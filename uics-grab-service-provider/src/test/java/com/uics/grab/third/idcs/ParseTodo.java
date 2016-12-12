package com.uics.grab.third.idcs;

import com.uics.grab.entity.IdcsTodo;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.net.SyslogAppender;
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
public class ParseTodo {
    @Test
    public void parse() throws IOException {
        parse(FileUtils.readFileToString(new File("/work/001_code/github/java/uics/uics-grab/uics-grab-service-provider/src/test/resources/third/idcs/代办.html")));
    }

    public List<IdcsTodo> parse(String html){
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
