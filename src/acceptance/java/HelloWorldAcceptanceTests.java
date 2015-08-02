import com.jayway.restassured.RestAssured;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class HelloWorldAcceptanceTests {

    private AcceptanceTestConfiguration configuration = new AcceptanceTestConfiguration();

    @Before
    public void setup() {
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

    @Test
    public void helloWorldResourceHasSelfLink() {
        given().
        when().
            get("/hello-world").
        then().
            assertThat().body("_links.self.href", equalTo(urlFor("/hello-world")));
    }

    private String urlFor(String resource) {
        return configuration.baseUri + ":" + configuration.port + resource;
    }
}
