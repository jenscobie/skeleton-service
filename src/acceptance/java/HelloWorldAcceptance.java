import com.jayway.restassured.RestAssured;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class HelloWorldAcceptance {

    @Test
    public void helloWorldReturnsOK() {
        AcceptanceTestConfiguration configuration = new AcceptanceTestConfiguration();

        RestAssured.baseURI = configuration.baseUri;
        RestAssured.port = configuration.port;

        given()
            .get("/hello-world")
        .then()
            .statusCode(equalTo(200));
    }
}
