package apiCalls;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiUtils {

    public ApiUtils(){
        RestAssured.baseURI = "http://216.10.245.166";
    }

    public JsonPath getJsonResponse(Response response) {
        String stringResponse = response.asString();
        return new JsonPath(stringResponse);
    }
}
