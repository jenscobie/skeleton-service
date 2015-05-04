import groovyx.net.http.RESTClient
import spock.lang.*

class HelloWorldContract extends spock.lang.Specification {

    def "GET returns 200"() {
        given:
        def client = new RESTClient('http://localhost:8080/')

        when:
        def response = client.get(path: 'hello-world')

        then:
        response.status == 200
    }
}