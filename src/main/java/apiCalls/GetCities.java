package apiCalls;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCities {

    @DataProvider(name = "cities")
    private Object [] citiesNames(){
        return new Object []  {"AsDFASDF", "Max", "London"};
    }

    @Test(dataProvider = "cities")
    public void test(String city) {
        System.out.println(getCitiesNames(city));

    }

    public String getCitiesNames(String cityName) {
        RestAssured.baseURI = "http://216.10.245.166";
        Response response = given().get("/Library/GetBook.php?AuthorName="+cityName).then().extract().response();
        int status = response.getStatusCode();
        String city =null;
        if(status==200){
            city =getJsonResponse(response).get("[0].book_name");
        }else if(status==404){
            city =null;
        }
        return city;
    }

    public JsonPath getJsonResponse(Response response) {
        String stringResponse = response.asString();
        return new JsonPath(stringResponse);
    }

}
