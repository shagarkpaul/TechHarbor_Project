package AdvanceSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class dropDownPractice {


    public static void main(String[] args){

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        // select class  to select an element from the drop down

        // there are three methods which will help us to select the option from a drop down

        // select by index --- int as a parameter

        // select by value --- String as a parameter "1"

        // select by visible text --- String as a parameter

        Select s = new Select(dropDown);

        s.selectByIndex(1);

        s.selectByValue("2");

        s.selectByVisibleText("Option 1");

       /* s.deselectByIndex(1);

        s.deselectByValue("2");

        s.deselectByVisibleText("Option 2");*/

        List<WebElement> allOptions = s.getOptions();

        for (int i = 0 ; i < allOptions.size(); i++){

            String text = allOptions.get(i).getText();

            System.out.println( text );
        }





    }
}
