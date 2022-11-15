package stepdefinitions.apisdefinitions;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
public class HomePageStepDef {


    @Given("user sets base url on homepage")
    public void userSetsBaseUrlOnHomepage() {
        Hooks.spec.pathParam("first", "hello");

    }

    @Then("user validates status code")
    public void userValidatesStatusCode() {
       Response response = given().spec(spec).when().get("/{first}");
       response.prettyPrint();
       response.then().statusCode(200);
    }

}
