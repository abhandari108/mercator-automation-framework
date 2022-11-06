package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Timestamp;
import java.time.Duration;

public class LoginMyStorePage {

    WebDriver driver;
    By emailAddress = By.cssSelector("input#email_create");
    By createAccount = By.id("SubmitCreate");
    public String userEmail;

    public LoginMyStorePage(WebDriver driver){
        this.driver = driver;
        //validate if we are on the correct page, if not throw an error message
        if(!driver.getTitle().equals("Login - My Store")){
            throw new IllegalStateException("This is not the Login My Store Page. The current page is "
            + driver.getCurrentUrl());
        }
    }

    public WebElement typeEmail(){
        return driver.findElement(emailAddress);
    }

    public WebElement btnCreateAccount() {
        return driver.findElement(createAccount);
    }

    public String enterEmail(String email1, String email2 ){
        userEmail = null;
        //using a timestamp to create a unique email address for creating new accounts
        java.util.Date date = new java.util.Date();
        System.out.println(new Timestamp(date.getTime()));

        typeEmail().sendKeys(email1 + date.getTime() + email2);
        String userEmail = driver.findElement(emailAddress).getAttribute("value");

        //creating a global variable userEmail to be returned for completing Personal details
        return userEmail;
    }

    public void clickCreateAccount() {
        btnCreateAccount().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.urlContains("#account-creation"));
        System.out.println("URL Matched");
    }

}
