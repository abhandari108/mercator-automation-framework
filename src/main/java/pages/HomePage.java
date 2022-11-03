package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By btn_SignIn = By.cssSelector("[class=\"login\"]");

    //This constructor is called each time an instance or an object is created for this class
    //Same session should be maintained hence forcing user to pass the driver object
    public HomePage(WebDriver driver){
        this.driver = driver;

    }

    public void clickSignIn(){

        driver.findElement(btn_SignIn).click();
    }

    public void validatePage(){
        //Adding validation to check user is on the correct page
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Login - My Store";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
    }
}
