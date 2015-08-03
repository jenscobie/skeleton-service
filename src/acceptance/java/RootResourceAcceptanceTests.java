import org.eclipse.jetty.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
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

    @Test
    public void rootResourceHasCuries() {
        given().
        when().
            get("/").
        then().
            assertThat().body("_links.curies.name", hasItems("doc")).
            assertThat().body("_links.curies.href", hasItems("http://www.example.com/docs/{rel}")).
            assertThat().body("_links.curies.templated", hasItems(true));
    }
}
