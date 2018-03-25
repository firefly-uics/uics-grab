package com.uics.grab.third;

import org.apache.commons.httpclient.HttpException;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.entity.ContentType;

import java.io.IOException;

// 动态构造调用串，灵活性更大
public class DynamicHttpclientCall {



    /**
     *
     * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:tem="http://tempuri.org/">
     <soap:Header/>
     <soap:Body>
     <tem:GetVrvAlarmHistory>
     <!--Optional:-->
     <tem:begintime>2015-01-01</tem:begintime>
     <tem:endtime>2018-03-01</tem:endtime>
     <tem:page>1</tem:page>
     <tem:pagesize>100</tem:pagesize>
     </tem:GetVrvAlarmHistory>
     </soap:Body>
     </soap:Envelope>

     response

     <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
     <soap:Body>
     <GetVrvAlarmHistoryResponse xmlns="http://tempuri.org/">
     <GetVrvAlarmHistoryResult>{"total":14,"rows":[{"ID":2477,"ClassName":"变电检修分公司","DeptName":"运检部-变电检修一班","AlarmType":"发现弱口令设备","DeviceName":"变电检修一班","IPAddress":"10.234.147.38","Status":"未处理","Dt":"2018-01-16T11:31:39.137"},{"ID":2479,"ClassName":"生产技术部","DeptName":"运检部-部门管理","AlarmType":"发现弱口令设备","DeviceName":"13F运检","IPAddress":"10.234.158.68","Status":"未处理","Dt":"2018-01-12T10:44:39.407"},{"ID":2474,"ClassName":"吉安供电公司","DeptName":"电力实业-吉安电力设计有限公司","AlarmType":"发现弱口令设备","DeviceName":"谢瑜","IPAddress":"10.234.157.207","Status":"未处理","Dt":"2018-01-10T10:05:09.807"},{"ID":2478,"ClassName":"明珠大酒店","DeptName":"综合服务中心","AlarmType":"发现弱口令设备","DeviceName":"郑文军","IPAddress":"10.234.158.121","Status":"未处理","Dt":"2018-01-04T09:28:41.61"},{"ID":2475,"ClassName":"吉安电力调度中心","DeptName":"调度中心-地区调度班","AlarmType":"发现弱口令设备","DeviceName":"调度台3","IPAddress":"10.234.158.179","Status":"未处理","Dt":"2018-01-03T17:40:31.927"},{"ID":2470,"ClassName":"河东大楼PC","DeptName":"电费管理中心","AlarmType":"发现弱口令设备","DeviceName":"抄表班公用9","IPAddress":"10.234.145.43","Status":"未处理","Dt":"2017-11-10T13:00:16.083"},{"ID":2471,"ClassName":"高新区分公司","DeptName":"培训分中心","AlarmType":"发现弱口令设备","DeviceName":"徐飞","IPAddress":"10.234.147.138","Status":"未处理","Dt":"2017-10-26T09:10:33.457"},{"ID":2476,"ClassName":"吉安供电公司","DeptName":"办公室","AlarmType":"发现弱口令设备","DeviceName":"肖建婷","IPAddress":"10.234.144.13","Status":"未处理","Dt":"2017-10-10T15:08:40.837"},{"ID":2473,"ClassName":"吉安电力实业总公司","DeptName":"吉安电力实业总公司","AlarmType":"发现弱口令设备","DeviceName":"刘文峰","IPAddress":"10.234.157.5","Status":"未处理","Dt":"2017-09-30T14:38:14.183"},{"ID":2472,"ClassName":"变电运行分公司","DeptName":"变电运行分公司","AlarmType":"发现弱口令设备","DeviceName":"110KV城北变","IPAddress":"10.234.159.188","Status":"未处理","Dt":"2017-09-25T05:50:55.613"},{"ID":2469,"ClassName":"","DeptName":"培训中心","AlarmType":"发现弱口令设备","DeviceName":"培训教室讲课机2","IPAddress":"192.168.1.127","Status":"未处理","Dt":"2017-09-15T23:53:39.463"},{"ID":2468,"ClassName":"","DeptName":"培训中心","AlarmType":"发现弱口令设备","DeviceName":"培训教室讲课机2","IPAddress":"192.168.1.129","Status":"未处理","Dt":"2017-09-15T23:52:39.457"},{"ID":2467,"ClassName":"吉安供电公司","DeptName":"电力实业-吉安电力设计有限公司","AlarmType":"发现弱口令设备","DeviceName":"设计院外聘2","IPAddress":"10.234.157.202","Status":"未处理","Dt":"2017-09-15T21:40:38.12"},{"ID":2465,"ClassName":"2","DeptName":"2","AlarmType":"发现弱口令设备","DeviceName":"2","IPAddress":"2","Status":"已处理","Dt":"2017-08-31T12:07:32.14"}]}</GetVrvAlarmHistoryResult>
     </GetVrvAlarmHistoryResponse>
     </soap:Body>
     </soap:Envelope>

     <?xml version="1.0" encoding="utf-8"?><soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"><soap:Body><GetStatisticsResponse xmlns="http://tempuri.org/"><GetStatisticsResult><xs:schema id="NewDataSet" xmlns="" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:msdata="urn:schemas-microsoft-com:xml-msdata"><xs:element name="NewDataSet" msdata:IsDataSet="true" msdata:MainDataTable="Statistics" msdata:UseCurrentLocale="true"><xs:complexType><xs:choice minOccurs="0" maxOccurs="unbounded"><xs:element name="Statistics"><xs:complexType><xs:sequence><xs:element name="SL" type="xs:string" minOccurs="0" /><xs:element name="XMID" type="xs:string" minOccurs="0" /><xs:element name="XMMC" type="xs:string" minOccurs="0" /></xs:sequence></xs:complexType></xs:element></xs:choice></xs:complexType></xs:element></xs:schema><diffgr:diffgram xmlns:msdata="urn:schemas-microsoft-com:xml-msdata" xmlns:diffgr="urn:schemas-microsoft-com:xml-diffgram-v1"><DocumentElement xmlns=""><Statistics diffgr:id="Statistics1" msdata:rowOrder="0"><SL>0</SL><XMID>1</XMID><XMMC>非法外联</XMMC></Statistics><Statistics diffgr:id="Statistics2" msdata:rowOrder="1"><SL>0</SL><XMID>2</XMID><XMMC>设备未注册</XMMC></Statistics><Statistics diffgr:id="Statistics3" msdata:rowOrder="2"><SL>782</SL><XMID>5</XMID><XMMC>保密检测系统未安装</XMMC></Statistics><Statistics diffgr:id="Statistics4" msdata:rowOrder="3"><SL>0</SL><XMID>9</XMID><XMMC>未安装防病毒软件</XMMC></Statistics></DocumentElement></diffgr:diffgram></GetStatisticsResult></GetStatisticsResponse></soap:Body></soap:Envelope>


     * @param args
     * @throws IOException
     * @throws HttpException
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        String soapRequestData = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                                 "   <soapenv:Header/>\n" +
                                 "   <soapenv:Body>\n" +
                                 "      <tem:GetStatistics/>\n" +
                                 "   </soapenv:Body>\n" +
                                 "</soapenv:Envelope>";

        HttpEntity httpEntity = EntityBuilder.create().setText(soapRequestData).setContentType(
                ContentType.TEXT_XML).setContentEncoding("utf-8").build();

        String res = HttpsUtils.post("https://10.234.156.8/zbjk/WebService/SecurityWebService.asmx?WSDL", null, null, httpEntity);

        System.out.println(res);

    }

}