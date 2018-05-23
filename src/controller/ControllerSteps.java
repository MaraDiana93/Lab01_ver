package controller;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Dell i5 on 18/05/2016.
 */
public class ControllerSteps {

    @Step("User enters website")
    public String getTitle() {
        System.setProperty("webdriver.chrome.driver", "D:\\downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.navigate().to("http://localhost:8080/index.jsp");

        String toReturn = webdriver.getTitle();

        webdriver.close();
        webdriver.quit();

        return toReturn;
    }
}
