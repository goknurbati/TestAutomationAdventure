package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
    public WebDriver driver;
    public LoginPage loginPage;
    public AddCustomerPage addCust;
    public SearchCustomerPage searchCust;

    //created for generating  random string for unique email address
    public static String randomestring(){
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }




}


