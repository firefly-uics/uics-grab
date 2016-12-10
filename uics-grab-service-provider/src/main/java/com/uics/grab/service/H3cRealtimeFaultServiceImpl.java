package com.uics.grab.service;

import com.uics.grab.entity.H3cRealtimeFault;
import org.dubbo.x.repository.DaoBase;
import org.dubbo.x.service.CURDServiceBase;
import com.uics.grab.repository.H3cRealtimeFaultDao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *  h3c告警信息
* Created by tom on 2016-12-07 14:34:58.
 */
public class H3cRealtimeFaultServiceImpl extends CURDServiceBase<H3cRealtimeFault> implements H3cRealtimeFaultService {
    @Autowired
    private H3cRealtimeFaultDao h3cRealtimeFaultDao;

    @Override
    public DaoBase<H3cRealtimeFault> getDao() {
        return h3cRealtimeFaultDao;
    }

    @Override
    public List<H3cRealtimeFault> parse(String html) {
        List<H3cRealtimeFault> result = new ArrayList<H3cRealtimeFault>();

        Document document = Jsoup.parse(html);

        Element table = document.getElementById("mainForm:data_data");
        Elements trs = table.select("tr");

        for (Element tr: trs){
            H3cRealtimeFault h3cRealtimeFault = new H3cRealtimeFault();

            Elements tds = tr.select("td");

            h3cRealtimeFault.setLevel(tds.get(1).text());

            h3cRealtimeFault.setSource(tds.get(2).text());
            h3cRealtimeFault.setFaultType(tds.get(3).text());
            h3cRealtimeFault.setInfo(tds.get(4).text());
            h3cRealtimeFault.setDateTime(tds.get(5).text());
            h3cRealtimeFault.setAnalyseReport(tds.get(6).text());
            h3cRealtimeFault.setFaultId(parseFaultId(tds.get(6).select("a").attr("onclick")));

            result.add(h3cRealtimeFault);
        }
        return result;
    }

    private String parseFaultId(String attr) {
        String result = "";

        if (null != attr){
            int startIndex = attr.indexOf("faultId=")+8;
            int endIndex = attr.indexOf("','faultReport'");
            result = attr.substring(startIndex, endIndex);
        }

        return result;
    }
}
