package apiCalls;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteCities extends ApiUtils {

    public Response deleteCitiesCall(String id, String number) {
        Response response = given().body("{\n" +
                "\"ID\" : \"" + id + number + "\"\n" +
                "}\n").when().post("/Library/DeleteBook.php").then().extract().response();
        return response;
    }

}
