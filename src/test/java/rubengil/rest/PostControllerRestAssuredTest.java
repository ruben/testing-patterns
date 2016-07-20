package rubengil.rest;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.WebIntegrationTest;
import rubengil.AbstractTest;
import rubengil.model.Post;
import rubengil.model.PostRepository;

import static io.restassured.RestAssured.when;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;

@WebIntegrationTest(randomPort = true)
public class PostControllerRestAssuredTest extends AbstractTest {

    @Autowired
    private PostRepository postRepository;

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void getsPost() {
        Post post = postRepository.findOne(1L);
        when().
                get("/posts/{id}", post.getId()).
                then().
                statusCode(equalTo(SC_OK)).
                body("id", is(1)).
                body("name", is("Refactoring Ruby applications"));
    }
}
