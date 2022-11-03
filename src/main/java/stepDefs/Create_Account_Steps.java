package stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginMyStorePage;

import java.util.List;
import java.util.Map;

public class Create_Account_Steps {
    private WebDriver driver;

    HomePage HomePage;
    LoginMyStorePage LoginMyStorePage;
    CreateAccountPage CreateAccountPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //initialising chromedriver variable from line 13
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        driver.quit();
    }
    @Given("I go to the fashion url {string}")
    public void i_go_to_the_fashion_url(String url) {
        driver.get(url);
    }
    @When("I click on Sign In")
    public void i_click_on_sign_in() throws InterruptedException {
        //Creating an instance or object of the HomePage class
        HomePage = new HomePage(driver);

        HomePage.clickSignIn();
        HomePage.validatePage();
        Thread.sleep(3000);
    }
    @And("I enter a valid email {string} timestamp {string}")
    public void i_enter_a_valid_email_timestamp(String email1, String email2) throws InterruptedException {
        LoginMyStorePage = new LoginMyStorePage(driver);
        LoginMyStorePage.enterEmail(email1, email2);
        Thread.sleep(3000);
    }
    @And("I click Create an account")
    public void i_click_create_an_account() {

        LoginMyStorePage.clickCreateAccount();
    }
    @When("I enter the personal details")
    public void i_enter_the_personal_details(DataTable dataTable) {

        CreateAccountPage = new CreateAccountPage(driver);
        List<Map<String, String>> personalDetailsList = dataTable.asMaps(String.class, String.class);
        String Title = personalDetailsList.get(0).get("Title");
        String FirstName = personalDetailsList.get(0).get("FirstName");

        CreateAccountPage.completePersonalDetails(Title, FirstName);


    }

    @And("Click Register")
    public void click_register() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("A new account should be created successfully")
    public void a_new_account_should_be_created_successfully() {
        // Write code here that turns the phrase above into concrete actions

    }
}
