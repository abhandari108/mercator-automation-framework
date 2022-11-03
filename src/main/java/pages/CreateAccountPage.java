package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {

        WebDriver driver;
//        By radioTitleMr = By.id("id_gender1");
//        By radioTitleMrs = By.id("id_gender2");
//        By txtFirstname = By.id("customer_firstname");
//        By txtLastname = By.id("customer_lastname");
//        By txtEmail = By.id("");
//        By txtPassword = By.id("passwd");
//        By dropDOBDate = By.id("days");
//        By dropDOBMonth = By.id("months");
//        By dropDOBYear = By.id("years");
//        By txtAddressFirstname = By.id("firstname");
//        By txtAddressLastname = By.id("lastname");
//        By txtAddress1 = By.id("address1");
//        By txtCity = By.id("city");
//        By dropState = By.id("id_state");
//        By txtPostCode = By.id("postcode");
//        By dropCountry = By.id("id_country");
//        By txtMobile = By.id("phone_mobile");
        By btnRegister = By.id("submitAccount");

        public CreateAccountPage(WebDriver driver) {
            this.driver = driver;

            String pagetitle = driver.getTitle();

            //validate if we are on the correct page, if not throw an error message
            if (!pagetitle.equals("Login - My Store")) {
                throw new IllegalStateException("This is not the Login My Store (Create an account) page. The current page is "
                        + driver.getCurrentUrl());
            }
        }

        public void completePersonalDetails(String Title, String Firstname) {

            if (Title.equals("Mrs"))
                driver.findElement(By.id("id_gender2")).click();
            else
                driver.findElement(By.id("id_gender1")).click();

            driver.findElement(By.id("customer_firstname")).sendKeys(Firstname);

        }

        public void clickRegister(){

            driver.findElement(btnRegister).click();
        }

}

