package rubengil;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class PostRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void findsPostById() throws Exception {
        Post post = postRepository.findOne(1L);
        assertThat(post, is(notNullValue()));
        assertThat(post.getName(), is("Refactoring Ruby applications"));
    }
}
