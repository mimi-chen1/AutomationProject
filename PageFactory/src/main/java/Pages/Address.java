package Pages;

import lombok.Generated;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class Address {

    WebDriver driver;
    @FindBy(xpath = "//*[contains(@class,'moving-tab')]")
    private WebElement title;

    @FindBy(id="streetname")
    private  WebElement inputStreetName;
    @FindBy(id="streetnumber")
    private  WebElement inputStreetNumber;
    @FindBy(id="city")
    private  WebElement inputCity;
    @FindBy(id="country")
    private  WebElement SelectCountry;
    @FindBy(id = "previous")
    private WebElement previousBtn;
    @FindBy(id = "finish")
    private WebElement finishBtn;
    @FindBy(id = "startAgain")
    private WebElement startAgainBtn;
    public Address(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isOpenPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            wait.until(ExpectedConditions.visibilityOf(getTitle()));
            return true;

        } catch (Exception e) {
            return false;
        }
    }


}
