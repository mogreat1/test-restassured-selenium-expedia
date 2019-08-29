package tests;

import apiCalls.AddCities;
import apiCalls.ApiUtils;
import apiCalls.DeleteCities;
import apiCalls.GetCities;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ApiTests{

    @Test
    private void successfulGetCity(){
        GetCities getCities = new GetCities();
        Response response = getCities.getCitiesCall("London");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    private void successfulDeleteCity(){
        String [] data = {"Paris", "id", "1234", "France"};
        AddCities addCities = new AddCities();
        DeleteCities deleteCities = new DeleteCities();
        Response addResponse = addCities.addCitiesCall(data[0], data[1], data[2], data[3]);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addResponse.getStatusCode(), 200);

        Response deleteResponse = deleteCities.deleteCitiesCall(data[1], data[2]);
        softAssert.assertEquals(deleteResponse.getStatusCode(), 200);
        softAssert.assertAll();

    }
}
