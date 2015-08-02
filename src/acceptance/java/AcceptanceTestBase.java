import com.jayway.restassured.RestAssured;
import org.junit.Before;

public class AcceptanceTestBase {

    private AcceptanceTestConfiguration configuration = new AcceptanceTestConfiguration();

    @Before
    public void setup() {
        RestAssured.baseURI = configuration.baseUri;
        RestAssured.port = configuration.port;
    }

    public String urlFor(String resource) {
        return configuration.baseUri + ":" + configuration.port + resource;
    }
}
