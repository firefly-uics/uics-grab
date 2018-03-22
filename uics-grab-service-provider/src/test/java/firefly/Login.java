package firefly;

import com.thoughtworks.selenium.Selenium;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springside.modules.test.selenium.Selenium2;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/26.
 */
public class Login {
    public static void main(String[] args){
        HtmlUnitDriver webDriver = new HtmlUnitDriver();
        webDriver.setJavascriptEnabled(true);

        Selenium2 selenium = new Selenium2(webDriver);

        while(true) {
            selenium.open("http://10.234.8.9/idcs/index.jsp");
            selenium.type(By.name("loginName"), "jaadmin");
            selenium.type(By.xpath("//*[@id=\"LoginForm\"]/table/tbody/tr[2]/td[2]/input[2]"), "123456");

            selenium.findElement(By.xpath("//*[@id=\"LoginForm\"]/table/tbody/tr[1]/td[3]/input")).click();
            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {

            }

            selenium.open("http://10.234.8.9/idcs/horizon/formview/view/viewtemplate/view.template.normal.jsp?viewid=HZ29ee8e3e0b4090013e0b5a6d71005a");


            HtmlUnitDriver htmlUnitDriver = (HtmlUnitDriver) selenium.getDriver();


            System.out.println("通知:..." );

            try {
                FileUtils.writeStringToFile(new File("D:\\apache-tomcat-8.0.39\\tmp\\third\\idcs\\notification.html"),htmlUnitDriver.getPageSource(), "utf8", false);
            } catch (IOException e) {

            }

            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {

            }

            selenium.open("http://10.234.8.9/idcs/horizon/formview/view/viewtemplate/view.template.normal.jsp?viewid=HZmfbts5JDIy8imJaxpbCaPFrA0FbuN7");

            System.out.println("代办:..." );

            try {
                FileUtils.writeStringToFile(new File("D:\\apache-tomcat-8.0.39\\tmp\\third\\idcs\\todo.html"),htmlUnitDriver.getPageSource(), "utf8", false);
            } catch (IOException e) {

            }
            try {
                Thread.sleep(5*60*1000);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }

    }
}
