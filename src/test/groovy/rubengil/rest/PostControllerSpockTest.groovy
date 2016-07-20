package rubengil.rest

import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest
import rubengil.TestingPatternsApplication
import spock.lang.Specification

@SpringApplicationConfiguration(TestingPatternsApplication.class)
@WebIntegrationTest(randomPort = true)
class PostControllerSpockTest extends Specification {

    @Value('${local.server.port}')
    private int port;

    def "Gets Post by id"() {
        when: "requesting a Post by id"
        def id = 1
        def client = new RESTClient("http://localhost:8080/rest-service-example/")
        def response = client.get(path: "http://localhost:${port}/posts/${id}")

        then: "the right post is expected"
        with(response) {
            data.id == 1
            data.name == "Refactoring Ruby applications"
            status == 200
        }
    }
}
