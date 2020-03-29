package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;

    public class AddCustomerPage {
    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
    }
    By lnkCustomers_menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
    By lnkCustomers_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");

    By btnAddnew=By.xpath("//a[@class='btn bg-blue']");

    By txtEmail=By.xpath("//input[@id='Email']");
    By txtPassword=By.xpath("//input[@id='Password']");

    By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

    By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
    By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
    By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
    By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");

    By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
    By rdMaleGender=By.id("Gender_Male");
    By rdFemaleGender=By.id("Gender_Female");

    By txtFirstName=By.xpath("//input[@id='FirstName']");
    By txtLastName=By.xpath("//input[@id='LastName']");

    By txtDob=By.xpath("//input[@id='DateOfBirth']");

    By txtCompanyName=By.xpath("//input[@id='Company']");

    By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");

    By btnSave= By.xpath("//button[name='save']");

    public String getPageTitle(){
        return ldriver.getTitle();
    }
    public void clickOnCustomerMenu(){
        ldriver.findElement(lnkCustomers_menu).click();
    }
    public void clickOnCustomersMenuItem(){
        ldriver.findElement(lnkCustomers_menuitem).click();
    }
    public void clickOnAddnew(){
        ldriver.findElement(btnAddnew).click();
    }
    public void setEmail(String email){
        ldriver.findElement(txtAdminContent).sendKeys(email);
    }
    public void setTxtPassword(String password){
        ldriver.findElement(txtPassword).sendKeys(password);
    }
    public void setCustomerRoles(String role) {
        if (!role.equals("Vendors")) {
            ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span"));
        }
            ldriver.findElement(txtcustomerRoles).click();
            WebElement listitem;

            if(role.equals("Administrators")){
                listitem=ldriver.findElement(lstitemAdministrators);
            }
            else if(role.equals("Guest")){
                listitem=ldriver.findElement(lstitemGuests);
            }
            else if(role.equals("Registered")){
                listitem=ldriver.findElement(lstitemRegistered);
            }
            else if(role.equals("Vendors")){
                listitem=ldriver.findElement(lstitemVendors);
            }
            else
                listitem=ldriver.findElement(lstitemGuests);
                listitem.click();

        JavascriptExecutor js = (JavascriptExecutor)ldriver;
        js.executeScript("arguments[0].click();",listitem);
    }
    public void setManagerOfVendor(String value){
        Select drp = new  Select(ldriver.findElement(drpmgrOfVendor));
        drp.selectByVisibleText(value);
    }
    public void setGender(String gender){
        if(gender.equals("Male")){
            ldriver.findElement(rdMaleGender);
        }
        else if(gender.equals("Female")){
            ldriver.findElement(rdFemaleGender);
        }
        else
            ldriver.findElement(rdMaleGender);
    }
    public void setTxtFirstName(String firstname){
        ldriver.findElement(txtFirstName).sendKeys(firstname);
    }
    public void setTxtLastName(String lastname){
        ldriver.findElement(txtLastName).sendKeys(lastname);
    }
    public void setTxtDob(String dob){
        ldriver.findElement(txtDob).sendKeys();
    }
    public void setCompanyName(String companyName){
        ldriver.findElement(txtCompanyName);
    }
    public void setTxtAdminContent(String content){
        ldriver.findElement(txtAdminContent).sendKeys(content);
    }
    public void clickOnSave(){
        ldriver.findElement(btnSave).click();
    }
}
