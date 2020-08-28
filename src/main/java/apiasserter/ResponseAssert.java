package apiasserter;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import org.testng.asserts.Assertion;

public class ResponseAssert extends GenericAssert<ResponseAssert, JsonPath> {

    private ResponseAssert(JsonPath actual) {
        super(ResponseAssert.class, actual);
    }

    public static ResponseAssert assertThat(JsonPath actual){
        return new ResponseAssert(actual);
    }

    public ResponseAssert hasPathWithValue(String path, String expectedValue){
        String value = actual.get(path);

        Assertions.assertThat(value).isNotNull();
        Assertions.assertThat(value).isEqualTo(expectedValue);
        return this;
    }


}
