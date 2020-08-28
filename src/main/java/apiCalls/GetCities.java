package apiCalls;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetCities extends ApiUtils{

    public Response getCitiesCall(String cityName){
        return given()
                .get("/Library/GetBook.php?AuthorName="+cityName)
                .then()
                .extract()
                .response();
    }

    public String getCitiesNames(String[] cityNames) {
        String city =null;
        for(String cityName: cityNames){
            Response response = getCitiesCall(cityName);
            int status = response.getStatusCode();
            if(status==200) {
                city = getJsonResponse(response).get("[0].book_name");
                System.out.println(city);
                break;
            }
        }
        return city;
    }

}
