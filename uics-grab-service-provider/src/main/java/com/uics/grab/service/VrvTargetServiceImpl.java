package com.uics.grab.service;

import com.uics.grab.entity.VrvConfig;
import com.uics.grab.entity.VrvTarget;
import com.uics.grab.repository.VrvConfigDao;
import com.utils.HttpsUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.entity.ContentType;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.xpath.DefaultXPath;
import org.dubbo.x.repository.DaoBase;
import org.dubbo.x.service.CURDServiceBase;
import com.uics.grab.repository.VrvTargetDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *  vrv监控指标统计信息
* Created by tom on 2016-12-07 14:34:58.
 */
public class VrvTargetServiceImpl extends CURDServiceBase<VrvTarget> implements VrvTargetService {
    @Autowired
    private VrvTargetDao vrvTargetDao;
    @Autowired
    private VrvConfigDao vrvConfigDao;
    private Logger logger = LoggerFactory.getLogger(VrvTargetServiceImpl.class);

    @Override
    public DaoBase<VrvTarget> getDao() {
        return vrvTargetDao;
    }

    @Override
    public VrvTarget findByConfigIdAndXmid(String id, int i) {
        return vrvTargetDao.findByConfigIdAndXmid(id, i);
    }

    @Override
    public List<VrvTarget> syncStatistics(VrvConfig vrvConfig) {
        List<VrvTarget> varTargets = new ArrayList<VrvTarget>();

        String soapRequestData = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                                 "   <soapenv:Header/>\n" +
                                 "   <soapenv:Body>\n" +
                                 "      <tem:GetStatistics/>\n" +
                                 "   </soapenv:Body>\n" +
                                 "</soapenv:Envelope>";

        HttpEntity httpEntity = EntityBuilder.create().setText(soapRequestData).setContentType(
                ContentType.TEXT_XML).setContentEncoding("utf-8").build();

        try {
            String res = HttpsUtils
                    .post("https://"+vrvConfig.getIp()+"/zbjk/WebService/SecurityWebService.asmx?WSDL", null, null, httpEntity);

            Document doc = DocumentHelper.parseText(res);

            DefaultXPath xpath = new DefaultXPath("//Statistics");

            List list = xpath.selectNodes(doc);

            for (Object o: list){
                Element e = (Element)o;
                VrvTarget vrvTarget = new VrvTarget();
                vrvTarget.setConfig(vrvConfig);
                vrvTarget.setSl(Integer.parseInt(e.elementText("SL")));
                vrvTarget.setXmid(Integer.parseInt(e.elementText("XMID")));
                vrvTarget.setXmmc(e.elementText("XMMC"));

                logger.debug("vrvTarget:{}", vrvTarget);

                varTargets.add(vrvTarget);
            }

        } catch (Exception e) {
            logger.error("sync error!", e);
        }
        return varTargets;
    }

    @Override
    public String alarmHistory(String area, String type, String begin, String end) {

        String soapRequestData = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:tem=\"http://tempuri.org/\">\n"
                                 + "     <soap:Header/>\n"
                                 + "     <soap:Body>\n"
                                 + "     <tem:GetVrvAlarmHistory>\n"
                                 + "     <!--Optional:-->\n"
                                 + "     <tem:begintime>2010-01-01</tem:begintime>\n"
                                 + "     <tem:endtime>2030-01-01</tem:endtime>\n"
                                 + "     <tem:page>1</tem:page>\n"
                                 + "     <tem:pagesize>1000</tem:pagesize>\n"
                                 + "     </tem:GetVrvAlarmHistory>\n"
                                 + "     </soap:Body>\n"
                                 + "     </soap:Envelope>";

        HttpEntity httpEntity = EntityBuilder.create().setText(soapRequestData).setContentType(
                ContentType.TEXT_XML).setContentEncoding("utf-8").build();

        try {
            VrvConfig vrvConfig = vrvConfigDao.findOne(area);
            if (null != vrvConfig){
                String res = HttpsUtils
                        .post("https://"+vrvConfig.getIp()+"/zbjk/WebService/SecurityWebService.asmx?WSDL", null, null, httpEntity);

                Document doc = DocumentHelper.parseText(res);
                Element body = (Element)doc.getRootElement().elements().get(0);
                Element getVrvAlarmHistoryResponse = (Element)body.elements().get(0);
                Element getVrvAlarmHistoryResult = (Element)getVrvAlarmHistoryResponse.elements().get(0);

                if (null != getVrvAlarmHistoryResult) {
                    return getVrvAlarmHistoryResult.getText();
                }

            }
        }catch (Exception e){
            logger.warn("get alarmHistory", e);
        }

        return "{}";
    }
}
