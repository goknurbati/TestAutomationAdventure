package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class steps extends BaseClass {

    @Given("User launch Chrome browser")
    public void user_launch_Chrome_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_URL(String url) {
        driver.navigate().to(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password) {
        loginPage.setUserName(email);
        loginPage.setPassword(password);

    }

    @When("Click on Login")
    public void click_on_Login() {
        loginPage.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }
        else
            Assert.assertEquals(title,driver.getTitle());
        System.out.println(title);
    }

    @When("User click on Logout link")
    public void user_click_on_Logout_link() throws InterruptedException {
        loginPage.clickLogout();
        Thread.sleep(3000);
    }

    @Then("close browser")
    public void close_browser(){
        driver.quit();
    }

    //Customer Step definitions

    @Then("User can view Dashboard")
    public void user_can_view_Dashboard() {
        addCust = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle() );
    }
    @When("User click on customers menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        Thread.sleep(3000);
        addCust.clickOnCustomerMenu();
    }
    @When("click on customers menu item")
    public void click_on_customers_menu_item() throws InterruptedException {
        Thread.sleep(3000);
        addCust.clickOnCustomersMenuItem();
    }
    @When("click on Add new button")
    public void click_on_Add_new_button() throws InterruptedException {
        addCust.clickOnAddnew();
        Thread.sleep(3000);
    }
    @Then("User can view Add new customer page")
    public void user_can_view_Add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
    }
    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        String email = randomestring()+"@gmail.com";
        addCust.setEmail(email);
        addCust.setTxtPassword("test123");

        //Registered default
        //The customer cannot be in both 'Guest' and 'Registered' customer roles
        //Add the customer to 'Guest' or 'Registered' customer role

        addCust.setCustomerRoles("Guest");
        Thread.sleep(3000);

        addCust.setManagerOfVendor("Vendor 2");
        addCust.setGender("Male");
        addCust.setTxtFirstName("Goknur");
        addCust.setTxtLastName("BATI");
        addCust.setTxtDob("31.10.1985");
        addCust.setCompanyName("Coca Cola");
        addCust.setTxtAdminContent("This is for testing");
    }
    @When("click on Save button")
    public void click_on_Save_button() throws InterruptedException {
        addCust.clickOnSave();
        Thread.sleep(3000);
    }
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String message) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains("The new customer has been added successfully"));
    }
        //Step for searching a cutomer using emailID
    @When("enter customer email")
    public void enter_customer_email() {
        searchCust = new SearchCustomerPage(driver);
        searchCust.setEmail("victoria_victoria@nopCommerce.com");
    }

    @When("click on search button")
    public void click_on_search_button() throws InterruptedException {
        searchCust.clickSearch();
        Thread.sleep(3000);
    }

    @Then("user should found email in the search table")
    public void user_should_found_email_in_the_search_table() {
       boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
       Assert.assertEquals(true,status);
    }

    //steps for searching a customer with using  firstname and lastname

    @When("enter customer firstname")
    public void enter_customer_firstname() {
        //here we have new scenario because of that so we need to page object class again.
        // Because new scenario started here.
        searchCust = new SearchCustomerPage(driver);
        searchCust.setFirstName("Victoria");
    }

    @Then("click on search lastname")
    public void click_on_search_lastname() {
        searchCust.setLastName("Terces");
    }

    @Then("user should found name in the search table")
    public void user_should_found_name_in_the_search_table() {
        boolean status = searchCust.searchCustomerByName("Victoria Terces");
        Assert.assertEquals(true,status);
    }



}


