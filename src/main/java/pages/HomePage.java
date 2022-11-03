package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By btn_SignIn = By.cssSelector("[class=\"login\"]");

    //This constructor is called each time an instance or an object is created for this class
    //Same session should be maintained hence forcing user to pass the driver object
    public HomePage(WebDriver driver){
        this.driver = driver;

        String pagetitle = driver.getTitle();

        //validate if we are on the correct page, if not throw an error message
        if (!pagetitle.equals("My Store")) {
            throw new IllegalStateException("This is not the My Store Home page. The current page is "
                    + driver.getCurrentUrl());
        }
    }

    public void clickSignIn(){
        driver.findElement(btn_SignIn).click();
    }

}
