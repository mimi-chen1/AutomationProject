package tests;

import Pages.Address;
import Pages.Enter;
import Pages.Account;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterTest {

    @Test
    public void Test1() throws InterruptedException {

        WebDriver driver =new ChromeDriver();
        driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
        driver.manage().window().fullscreen();

        Enter enter =new Enter(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf( enter.getFirstname())).sendKeys("rivki");
//        enter.getFirstname().sendKeys("rivki");
        wait.until(ExpectedConditions.visibilityOf( enter.getLastname())).sendKeys("meller");
//        enter.getLastname().sendKeys("meller");
        wait.until(ExpectedConditions.visibilityOf( enter.getEmail())).sendKeys("r0534198184@gmail.com");
//        enter.getEmail().sendKeys("r0534198184@gmail.com");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf( enter.getButtonNext())).click();


        Account account = new Account(driver);
        Assertions.assertTrue(account.isOpenPage(),"account page");

        wait.until(ExpectedConditions.visibilityOf( account.getAdvanced())).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(account.getNextButton())).click();

        Address address = new Address(driver);
        Assertions.assertTrue(address.isOpenPage(),"eddress page");

        wait.until(ExpectedConditions.visibilityOf(address.getInputCity())).sendKeys("bb");
        wait.until(ExpectedConditions.visibilityOf(address.getInputStreetName())).sendKeys("yeoshua");
        wait.until(ExpectedConditions.visibilityOf(address.getInputStreetNumber())).sendKeys("8");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(address.getFinishBtn())).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(address.getStartAgainBtn())).click();
        Assertions.assertTrue(enter.isOpenPage(),"enter page");



    }
}
