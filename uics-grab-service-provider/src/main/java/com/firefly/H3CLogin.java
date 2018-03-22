package com.firefly;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springside.modules.test.selenium.Selenium2;

/**
 * Created by Administrator on 2016/11/26.
 */
public class H3CLogin {
    public static void main(String[] args){
        WebDriver webDriver = new HtmlUnitDriver();

        Selenium2 selenium = new Selenium2(webDriver);

        selenium.open("http://10.234.156.189:8080/imc/login.jsf");
        selenium.type(By.id("loginForm:loginName"),"cx");
        selenium.type(By.id("loginForm:password"),"cx123");
        selenium.findElement(By.id("loginForm")).submit();

        selenium.open("http://10.234.156.189:8080/imc/fault/realtimefault/main.jsf");

        HtmlUnitDriver htmlUnitDriver = (HtmlUnitDriver)selenium.getDriver();

        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(htmlUnitDriver.getPageSource());

    }
}
