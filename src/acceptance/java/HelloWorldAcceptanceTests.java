import com.jayway.restassured.RestAssured;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class HelloWorldAcceptanceTests {

    @Before
    public void setup() {
        AcceptanceTestConfiguration configuration = new AcceptanceTestConfiguration();
        RestAssured.baseURI = configuration.baseUri;
        RestAssured.port = configuration.port;
    }

    @Test
    public void helloWorldReturnsOK() {
        given().
        when()
            .get("/hello-world")
        .then()
            .statusCode(equalTo(HttpStatus.OK_200));
    }
}
