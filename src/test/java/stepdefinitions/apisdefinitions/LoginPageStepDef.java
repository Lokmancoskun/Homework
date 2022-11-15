package stepdefinitions.apisdefinitions;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.Note;
import java.util.HashMap;
import java.util.Map;
import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

public class LoginPageStepDef {
    String token;
    Response response;

    Map<String, String> loginRequestBody = new HashMap<>();

    @Given("user sets pathparams for login page")
    public void userSetsPathparamsForLoginPage() {

        Hooks.spec.pathParam("first", "login");
    }
    @And("user logs in with credentials {string}, {string}")
    public void userLogsInWithCredentials(String email, String password) {
        loginRequestBody.put("email",email);
        loginRequestBody.put("password",password);

    }
    @And("user sends the POST request and gets the login token")
    public void userSendsThePOSTRequestAndGetsTheLoginToken() {
        response = given().spec(spec).contentType(ContentType.JSON).body(loginRequestBody).when().post("/{first}");
        response.prettyPrint();
        token = response.then().extract().path("token");
    }

    String userId;
    String noteID;
    @Then("user validates post request status code")
    public void userValidatesPostRequestStatusCode() {
        response.then().statusCode(200);
    }

    @When("user sends GET request for all profile information")
    public void userSendsGETRequestForAllProfileInformation() {
        response = given().contentType(ContentType.JSON).cookies("token", token).when().get("https://master.hiring-assignment.qa.c66.me:3001/v3/profile");
    }

    @And("user sends POST request to create notes")
    public void userSendsPOSTRequestToCreateNotes() {
        userId = response.then().extract().path("user.id");

        Map<String, String> map = new HashMap<>();
        map.put("text","New Noteeeee!!!!!");
        map.put("userId",userId);
        response = given().contentType(ContentType.JSON).cookies("token",token).body(map).when().post("https://master.hiring-assignment.qa.c66.me:3001/v3/note");
        response.prettyPrint();

    }
    @And("user sends GET request to get noteID")
    public void userSendsGETRequestToGetNoteID() {
        noteID = response.then().extract().path("id");
        String url = "https://master.hiring-assignment.qa.c66.me:3001/v3/note/";
        response = given().cookies("token",token).when().pathParam("nodeID",noteID).get(url+"{nodeID}");
            }

    @Then("user sends POST request for searching relevant notes")
    public void userSendsPOSTRequestForSearchingRelevantNotes() {
        int size = 3;
        int skip = 5;
        Map<String, Object> searchBody = new HashMap<>();
        searchBody.put("text","Logan");
        searchBody.put("size",size);
        searchBody.put("skip",skip);

        response = given().contentType(ContentType.JSON).cookies("token",token).body(searchBody).when().post("https://master.hiring-assignment.qa.c66.me:3001/v3/search");

        response.prettyPrint();

        Note[] notes = response.then().extract().as(Note[].class);

        Assert.assertTrue(notes.length <= size);

    }

    }



