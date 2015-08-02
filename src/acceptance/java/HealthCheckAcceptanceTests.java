import com.jayway.restassured.RestAssured;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class HealthCheckAcceptanceTests extends AcceptanceTestBase {

    @Before
    public void setup() {
        RestAssured.port = 8081;
    }

    @Test
    public void helthCheckReturnsOK() {
        given().
        when()
            .get("/healthcheck")
        .then()
            .statusCode(equalTo(HttpStatus.OK_200));
    }

    @Test
    public void healthCheckIsHealthy() {
        given().
        when().
            get("/healthcheck").
        then().
            assertThat().body("deadlocks.healthy", equalTo(true)).
            assertThat().body("template.healthy", equalTo(true));
    }
}
