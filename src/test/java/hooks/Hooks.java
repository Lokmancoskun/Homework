package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

public class Hooks {

    public static RequestSpecification spec;

    @Before(value = "@loginUI")
    public void setup() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("homepage")).build();

    }

    @Before(value = "@HomeApi")
    public void setupApi() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("home")).build();

    }
    @Before(value = "@LoginApi")
    public void setupLoginApi() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("home")).build();

    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "screenshots");
        }

        Driver.closeDriver();
    }
}