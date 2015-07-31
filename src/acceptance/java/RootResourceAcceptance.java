import com.jayway.restassured.RestAssured;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RootResourceAcceptance {

    private AcceptanceTestConfiguration configuration = new AcceptanceTestConfiguration();

    @Before
    public void setup() {
        RestAssured.baseURI = configuration.baseUri;
        RestAssured.port = configuration.port;
    }

    @Test
    public void rootResourceReturns200OK() {
        given().
        when().
            get("/").
        then().
            statusCode(equalTo(HttpStatus.OK_200));
    }

    @Test
    public void rootResourceHasSelfLink() {
        given().
        when().
            get("/").
        then().
            assertThat().body(equalTo(rootRepresentationWith(configuration)));
    }

    private String rootRepresentationWith(AcceptanceTestConfiguration configuration) {
        return "{\"links\":[" +
               "{\"name\":\"self\"," +
               "\"href\":\"" + configuration.baseUri + ":" + configuration.port + "/\"}]}";
    }
}
