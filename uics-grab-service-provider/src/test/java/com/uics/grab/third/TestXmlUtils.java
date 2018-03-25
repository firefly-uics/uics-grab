package com.uics.grab.third;

import com.utils.XMLUtil;
import org.apache.commons.httpclient.HttpException;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.entity.ContentType;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.xpath.DefaultXPath;

import java.io.IOException;
import java.util.List;

// 动态构造调用串，灵活性更大
public class TestXmlUtils {



    /**
     * @param args
     * @throws IOException
     * @throws HttpException
     */
    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><GetStatisticsResponse xmlns=\"http://tempuri.org/\"><GetStatisticsResult><xs:schema id=\"NewDataSet\" xmlns=\"\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\"><xs:element name=\"NewDataSet\" msdata:IsDataSet=\"true\" msdata:MainDataTable=\"Statistics\" msdata:UseCurrentLocale=\"true\"><xs:complexType><xs:choice minOccurs=\"0\" maxOccurs=\"unbounded\"><xs:element name=\"Statistics\"><xs:complexType><xs:sequence><xs:element name=\"SL\" type=\"xs:string\" minOccurs=\"0\" /><xs:element name=\"XMID\" type=\"xs:string\" minOccurs=\"0\" /><xs:element name=\"XMMC\" type=\"xs:string\" minOccurs=\"0\" /></xs:sequence></xs:complexType></xs:element></xs:choice></xs:complexType></xs:element></xs:schema><diffgr:diffgram xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\" xmlns:diffgr=\"urn:schemas-microsoft-com:xml-diffgram-v1\"><DocumentElement xmlns=\"\"><Statistics diffgr:id=\"Statistics1\" msdata:rowOrder=\"0\"><SL>0</SL><XMID>1</XMID><XMMC>非法外联</XMMC></Statistics><Statistics diffgr:id=\"Statistics2\" msdata:rowOrder=\"1\"><SL>0</SL><XMID>2</XMID><XMMC>设备未注册</XMMC></Statistics><Statistics diffgr:id=\"Statistics3\" msdata:rowOrder=\"2\"><SL>782</SL><XMID>5</XMID><XMMC>保密检测系统未安装</XMMC></Statistics><Statistics diffgr:id=\"Statistics4\" msdata:rowOrder=\"3\"><SL>0</SL><XMID>9</XMID><XMMC>未安装防病毒软件</XMMC></Statistics></DocumentElement></diffgr:diffgram></GetStatisticsResult></GetStatisticsResponse></soap:Body></soap:Envelope>";

        Document doc = DocumentHelper.parseText(xml);

        DefaultXPath xpath = new DefaultXPath("//Statistics");

        List list = xpath.selectNodes(doc);

        for (Object o: list){
            Element e = (Element)o;
            System.out.println(e.elementText("SL"));
            System.out.println(e.elementText("XMID"));
            System.out.println(e.elementText("XMMC"));
        }

    }

}