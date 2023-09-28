package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;


public class Main_Page {
    WebDriver driver;
    Actions actions = new Actions(Driver.getDriver());


    public Main_Page() {PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='TopbarSearchInputButton-baseButton']")
    public WebElement searchBox;

    @FindBy(xpath = "(//span[contains(@class,'TypographyPresentation TypographyPresentation--m')])[3]")
    public WebElement projectButton;

    @FindBy(xpath ="(//div[text()='test1234'])" )
    public WebElement project;

    @FindBy(xpath ="//div[@aria-label='Ahmet']" )
    public WebElement task01;
    @FindBy(xpath ="//div[@aria-label='bug']" )
    public WebElement task02;
    @FindBy(xpath ="//div[@aria-label='bug2']" )
    public WebElement task03;

    public void searchTheProjectAndAssertThePage(String projectName) {

        actions.moveToElement(searchBox).click().sendKeys(projectName).sendKeys(Keys.ENTER).perform();

        ReusableMethods.waitForVisibility(projectButton, 5);
        projectButton.click();
        ReusableMethods.waitFor(10);
       // WebElement project = driver.findElement(By.xpath("//div[text()='" + projectName + "']"));
        //System.out.println("project = " + project);
        //actions.moveToElement(project).click().perform();
        project.click();

    }

    public void assertTheTasks(String taskName01, String taskName02, String taskName03) {

        //WebElement task01 = driver.findElement(By.xpath("//div[@aria-label='" + taskName01 + "']"));
        //WebElement task02 = driver.findElement(By.xpath("//div[@aria-label='" + taskName02 + "']"));
        //WebElement task03 = driver.findElement(By.xpath("//div[@aria-label='" + taskName03 + "']"));

        System.out.println("task01.getText() = " + task01.getText());
        System.out.println("task02.getText() = " + task02.getText());
        System.out.println("task03.getText() = " + task03.getText());

        Assert.assertEquals(taskName01, task01.getText());
        Assert.assertEquals(taskName02, task02.getText());
        Assert.assertEquals(taskName03, task03.getText());

    }


    public void setUp() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Driver.getDriver().get(ConfigReader.getProperty("asanaURL"));
    }

    public void tearDown() {
        Driver.closeDriver();
    }
}
