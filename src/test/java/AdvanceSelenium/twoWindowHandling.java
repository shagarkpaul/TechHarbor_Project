package AdvanceSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Set;
import java.util.concurrent.TimeUnit;

public class twoWindowHandling {


    public static void main(String[] args){

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));

        clickHereButton.click();

        String mainWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for(String s : allWindows){

            if (!mainWindow.equals(s)){

                driver.switchTo().window(s);
            }
        }


        WebElement newWindowText = driver.findElement(By.xpath("//div[@class='example']/h3"));

        System.out.println(newWindowText.getText());





    }
}
