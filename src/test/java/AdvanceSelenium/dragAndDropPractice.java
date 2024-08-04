package AdvanceSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class dragAndDropPractice {


    public static void main (String[] args){

        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Actions class will be used to automate anything related action with mouse or keyboard

        Actions act = new Actions(driver);

        WebElement colA = driver.findElement(By.xpath("//div[@id='column-a']"));

        WebElement colB = driver.findElement(By.xpath("//div[@id='column-b']"));

        // dragAndDrop takes two parameter. One is the from webelement and another one is the to webelement

        // dragAndDropBy take three parameter. One is the webelement that we want drag and the other two is value for
        // x-axis and y-axis

        act.dragAndDrop(colA, colB).build().perform();

        act.dragAndDropBy(colA, 200, 300).build().perform();



    }
}
