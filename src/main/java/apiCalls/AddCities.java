package apiCalls;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AddCities extends ApiUtils {


    public Response addCitiesCall(String name, String id, String number, String area){
       Response response = given().body("{\n" +
                "\"name\":\""+name+"\",\n" +
                "\"isbn\":\""+id+"\",\n" +
                "\"aisle\":\""+number+"\",\n" +
                "\"author\":\""+area+"\"\n" +
                "}").when().post("/Library/Addbook.php").then().extract().response();
       return response;

    }

}
