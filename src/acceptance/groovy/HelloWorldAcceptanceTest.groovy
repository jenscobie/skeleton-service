import groovyx.net.http.RESTClient
import spock.lang.*

class HelloWorldAcceptanceTest extends spock.lang.Specification {

    def "GET returns 200"() {
        given:
        def client = new RESTClient('http://localhost:8080/')

        when:
        def response = client.get(path: 'hello-world')

        then:
        response.status == 200
        response.contentType == "application/json"
        response.data.content == "Hello, Stranger!"
    }
}