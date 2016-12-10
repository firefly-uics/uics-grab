package com.uics.grab.third.h3c;

import com.uics.grab.entity.H3cRealtimeFault;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by tom on 16/12/8.
 */
public class ParseRealtimeFault {
    @Test
    public void parse() throws IOException {
        Document document = Jsoup.parse(new File("/work/001_code/github/java/uics/uics-grab/uics-grab-service-provider/src/test/resources/third/h3c/realtimefault.html"),"utf8");

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
            h3cRealtimeFault.setId(h3cRealtimeFault.getFaultId());

        }
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
