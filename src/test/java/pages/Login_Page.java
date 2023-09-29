package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class Login_Page {
    WebDriver driver;

    public Login_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath ="(//label[text()='Email address']/following::input)[1]" )
    public WebElement emailBox;

    @FindBy(xpath ="//div[text()='Continue']" )
    public WebElement continueButton;

    @FindBy(xpath ="(//input[contains(@class,'TextInputBase SizedTextInput')])[2]" )
    public WebElement passwordBox;

    @FindBy(xpath ="//div[text()='Log in']" )
    public WebElement loginButton;

    String email = ConfigReader.getProperty("email");
    String password = ConfigReader.getProperty("password");

    public void goToURLAndLogin() {
        emailBox.sendKeys(email);
        continueButton.click();
        passwordBox.click();
        passwordBox.sendKeys(password);
        loginButton.click();
    }
}
