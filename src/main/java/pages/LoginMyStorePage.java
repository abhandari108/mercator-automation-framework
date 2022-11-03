package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Timestamp;
import java.time.Duration;

public class LoginMyStorePage {

    WebDriver driver;
    By txtEmailAddress = By.cssSelector("input#email_create");
    By btn_CreateAccount = By.id("SubmitCreate");

    public LoginMyStorePage(WebDriver driver){
        this.driver = driver;
        //validate if we are on the correct page, if not throw an error message
        if(!driver.getTitle().equals("Login - My Store")){
            throw new IllegalStateException("This is not the Login My Store Page. The current page is "
            + driver.getCurrentUrl());
        }
    }

    public void enterEmail(String email1, String email2){
        //using a timestamp to create a unique email address for creating new accounts
        java.util.Date date = new java.util.Date();
        System.out.println(new Timestamp(date.getTime()));
        driver.findElement(txtEmailAddress).sendKeys(email1 + date.getTime() + email2);
    }

    public void clickCreateAccount() {
        driver.findElement(btn_CreateAccount).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.urlContains("#account-creation"));
        System.out.println("URL Matched");
    }

}
