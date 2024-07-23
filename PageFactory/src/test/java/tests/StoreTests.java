package tests;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StoreTests {


    @Test
    public void TestChromeStore() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/payment-gateway/index.php");
        driver.manage().window().fullscreen();
        //click buy now
        WebElement inputBuy = driver.findElement(By.tagName("input"));
        inputBuy.click();
        String str = driver.getTitle();
        if (str.equalsIgnoreCase("Guru99 Payment Gateway"))
            Assert.isTrue(true, "correct page");
        else
            Assert.isTrue(false, "incorrect page");


    }

    @Test
    public void TestChromeStore1() {
        //negativ testing
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/payment-gateway/index.php");
        driver.manage().window().fullscreen();
        //click buy now
        WebElement inputBuy = driver.findElement(By.tagName("input"));
        inputBuy.click();
        String str = driver.getTitle();
        if (str.equalsIgnoreCase("Guru99 Payment"))
            Assert.isTrue(true, "correct page");
        else
            Assert.isTrue(false, "incorrect page");


    }

    @Test
    public void TestStoreE2E(){
        //negativ testing
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/payment-gateway/index.php");
        driver.manage().window().fullscreen();
        //select quantity
        WebElement Squantity =driver.findElement(By.name("quantity"));
        Select qSelect= new Select(Squantity);
        qSelect.selectByIndex(3);
        //qSelect.selectByVisibleText("4");
        //click buy now
        WebElement inputBuy = driver.findElement(By.tagName("input"));
        inputBuy.click();
        //card number
        WebElement cardNum = driver.findElement(By.name("card_nmuber"));
        cardNum.sendKeys("1111222233334444");
        //month
        WebElement Smonth =driver.findElement(By.id("month"));
        Select mSelect= new Select(Smonth);
        mSelect.selectByIndex(3);
        //year
        //cvv
        //click pay

    }

}
