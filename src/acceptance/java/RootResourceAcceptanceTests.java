import com.jayway.restassured.RestAssured;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RootResourceAcceptanceTests extends AcceptanceTestBase {

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
            assertThat().body("_links.self.href", equalTo(urlFor("/")));
    }

    @Test
    public void rootResourceHasHelloLink() {
        given().
        when().
            get("/").
        then().
            assertThat().body("_links.hello.href", equalTo(urlFor("/hello-world")));
    }
}
