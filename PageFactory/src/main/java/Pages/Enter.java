package Pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter @Setter
public class Enter {
    WebDriver driver;
    @FindBy(xpath = "//*[contains(@class,'moving-tab')]")
    private WebElement title;
    @FindBy(name = "firstname")
    private WebElement firstname;
    @FindBy(name = "lastname")
    private  WebElement lastname;
    @FindBy(name = "email")
    private WebElement email;
    @FindBy(id = "next")
    private WebElement buttonNext;

    public Enter(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
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
