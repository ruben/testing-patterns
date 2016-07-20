package rubengil.rest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rubengil.AbstractTest;
import rubengil.model.Post;
import rubengil.model.PostRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@WebIntegrationTest(randomPort = true)
public class PostControllerRestTemplateTest extends AbstractTest {

    @Autowired
    private PostRepository postRepository;

    @Value("${local.server.port}")
    private int port;

    @Test
    public void getsPost() {
        Post post = postRepository.findOne(1L);
        ResponseEntity<Post> response = new TestRestTemplate().getForEntity("http://localhost:" + port + "/posts/{id}", Post.class, post.getId());
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        Post responsePost = response.getBody();
        assertThat(responsePost.getId().intValue(), is(1));
        assertThat(responsePost.getName(), is("Refactoring Ruby applications"));
    }
}
