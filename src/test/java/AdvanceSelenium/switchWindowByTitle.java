package AdvanceSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class switchWindowByTitle {



    public static void main(String[] args){

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));

        clickHereButton.click();

        windowByTitle(driver, "New Window");

        WebElement newWindowText = driver.findElement(By.xpath("//div[@class='example']/h3"));

        System.out.println(newWindowText.getText());

    }


    public static void windowByTitle( WebDriver driver, String title) {

        String mainWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for(String windowName : allWindows){

            if(!driver.switchTo().window(windowName).getTitle().equals(title)){

                driver.switchTo().window(mainWindow);
            }
        }

    }

}
