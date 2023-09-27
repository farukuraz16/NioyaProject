package pages;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BasePage {

    protected RequestSpecification specification;
    public static Response response;
    public static String boardID;
    public static JsonPath jsonPath;
    public static String listID;
    public static List<String> cardsID = new ArrayList<>();

    @Before
    public void setUpBaseURL(){
     //   specification = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseURL")).build();
    }

    public void userSetsTheURL(String baseURL) {
        specification = new RequestSpecBuilder().
                setBaseUri(baseURL).
                build();
    }

}
