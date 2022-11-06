package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage extends LoginMyStorePage{
    //extends LoginStorePage to use var userEmail globally

        WebDriver driver;
        By radioTitleMr = By.id("id_gender1");
        By radioTitleMrs = By.id("id_gender2");
        By txtFirstname = By.id("customer_firstname");
        By txtLastname = By.id("customer_lastname");
        By txtPassword = By.id("passwd");
        By dropDOBDate = By.id("days");
        By dropDOBMonth = By.id("months");
        By dropDOBYear = By.id("years");
        By txtAddress1 = By.id("address1");
        By txtCity = By.id("city");
        By dropState = By.id("id_state");
        By txtPostCode = By.id("postcode");
        By dropCountry = By.id("id_country");
        By txtMobile = By.id("phone_mobile");
        By btnRegister = By.id("submitAccount");

        public CreateAccountPage(WebDriver driver) {
            super(driver);//default constructor required
            this.driver = driver;

            String pagetitle = driver.getTitle();

            //validate if we are on the correct page, if not throw an error message
            if (!pagetitle.equals("Login - My Store")) {
                throw new IllegalStateException("This is not the Login My Store (Create an account) page. The current page is "
                        + driver.getCurrentUrl());
            }
        }

        public WebElement selectGenderMr(){
             return driver.findElement(radioTitleMr);
        }
        public WebElement selectGenderMrs(){
            return driver.findElement(radioTitleMrs);
        }
        public WebElement enterFirstName(){
            return driver.findElement(txtFirstname);
        }
        public WebElement enterLastName(){
             return driver.findElement(txtLastname);
        }
        public WebElement enterPassword(){
            return driver.findElement(txtPassword);
        }
        public WebElement selectDOBDate(){
            return driver.findElement(dropDOBDate);
        }
        public WebElement selectDOBMon(){
            return driver.findElement(dropDOBMonth);
        }
        public WebElement selectDOBYear(){
            return driver.findElement(dropDOBYear);
        }
        public WebElement enterAddress1(){
            return driver.findElement(txtAddress1);
        }
        public WebElement enterCity(){
            return driver.findElement(txtCity);
        }
        public WebElement selectCountry(){
            return driver.findElement(dropCountry);
         }
        public WebElement enterMobile(){
            return driver.findElement(txtMobile);
        }
        public WebElement selectState(){
            return driver.findElement(dropState);
        }
        public WebElement enterPostcode(){
            return driver.findElement(txtPostCode);
        }
        public WebElement btnRegister(){
            return driver.findElement(btnRegister);
        }

        public void completePersonalDetails(String Title, String FirstName, String LastName, String Password, String DobDate,
            String DobMon, String DobYear, String Address, String City, String State, String ZipCode, String Country, String Mobile)  {
            if (Title.equals("Mrs"))
                selectGenderMrs().click();
            else
                selectGenderMr().click();

            enterFirstName().sendKeys(FirstName);
            enterLastName().sendKeys(LastName);
            enterPassword().sendKeys(Password);
            selectDOBDate().sendKeys(DobDate);
            selectDOBMon().sendKeys(DobMon);
            selectDOBYear().sendKeys(DobYear);
            enterAddress1().sendKeys(Address);
            enterCity().sendKeys(City);
            selectState().sendKeys(State);
            enterPostcode().sendKeys(ZipCode);
            selectCountry().sendKeys(Country);
            enterMobile().sendKeys(Mobile);

    }

        public void clickRegister(){
            btnRegister().click();
        }

}


