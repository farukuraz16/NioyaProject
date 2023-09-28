package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login_Page;
import pages.Main_Page;

public class UI_Stepdefinitions {
    Login_Page loginPage = new Login_Page();
    Main_Page mainPage = new Main_Page();

    @When("go to URL and login")
    public void goToURLAndLogin() {
        loginPage.goToURLAndLogin();
    }

    @And("search the project {string} and assert the page")
    public void searchTheProjectAndAssertThePage(String projectName) {
        mainPage.searchTheProjectAndAssertThePage(projectName);

    }


    @Then("assert the tasks {string} {string} {string}")
    public void assertTheTasks(String taskName01, String taskName02, String taskName03) {
        mainPage.assertTheTasks(taskName01,taskName02,taskName03);
    }


    @When("set up")
    public void setUp() {
        mainPage.setUp();
    }

    @Then("tear down")
    public void tearDown() {
        mainPage.tearDown();
    }
}
