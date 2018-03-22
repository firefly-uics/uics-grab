package com.firefly;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springside.modules.test.selenium.Selenium2;

/**
 * Created by Administrator on 2016/11/26.
 */
public class Login {
    public static void main(String[] args){
        HtmlUnitDriver webDriver = new HtmlUnitDriver();
        webDriver.setJavascriptEnabled(true);

        Selenium2 selenium = new Selenium2(webDriver);
        selenium.open("http://www.baidu.com/");

//        selenium.open("http://10.234.8.9/idcs/index.jsp");
//        selenium.type(By.name("loginName"),"jaadmin");
//        selenium.type(By.xpath("//*[@id=\"LoginForm\"]/table/tbody/tr[2]/td[2]/input[2]"),"123456");
//
//        selenium.findElement(By.xpath("//*[@id=\"LoginForm\"]/table/tbody/tr[1]/td[3]/input")).click();
//        try {
//            Thread.sleep(2000l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        selenium.open("http://10.234.8.9/idcs/horizon/formview/view/viewtemplate/view.template.normal.jsp?viewid=HZ29ee8e3e0b4090013e0b5a6d71005a");
//        selenium.open("http://10.234.8.9/idcs/horizon/formview/view/viewtemplate/view.template.normal.jsp?viewid=HZmfbts5JDIy8imJaxpbCaPFrA0FbuN7");
//
//
//        HtmlUnitDriver htmlUnitDriver = (HtmlUnitDriver)selenium.getDriver();
//
//
//        System.out.println(htmlUnitDriver.getPageSource());

    }
}
