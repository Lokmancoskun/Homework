package stepdefinitions.uidefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LocatorsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class LoginStepDef {
    LocatorsPage locators = new LocatorsPage();

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        Driver.getDriver().get(ConfigReader.getProperty("homepage"));

    }

    @When("user clicks on home")
    public void userClicksOnHome() {
        locators.home.click();

    }

    @And("user verifies testing! text is visible")
    public void userVerifiesTestingTextIsVisible() {
        locators.testingText.isDisplayed();
    }

    @And("user verifies Hello world! text is visible")
    public void userVerifiesHelloWorldTextIsVisible() {
        locators.helloWorldText.isDisplayed();
    }
    @And("user clicks on login")
    public void userClicksOnLogin() {
        locators.login.click();
    }

    @And("user logs in with credentials")
    public void userLogsInWithCredentials() {
        locators.email.sendKeys(ConfigReader.getProperty("email"));
        locators.password.sendKeys(ConfigReader.getProperty("password"));
    }

    @And("user clicks on search")
    public void userClicksOnSearch() {
        locators.search.click();
    }


    @Then("user makes search")
    public void userMakesSearch() {
        locators.searchBox.sendKeys("Logan");
    }

    @And("user clicks on object table")
    public void userClicksOnObjectTable() {
        ReusableMethods.waitForVisibility(locators.ownerObject, 3);
        locators.ownerObject.click();
    }

}
