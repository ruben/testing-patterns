package rubengil.model;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class PostRepositoryIntegrationTest extends AbstractRepositoryIntegrationTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void findsPostById() throws Exception {
        Post post = postRepository.findOne(1L);
        assertThat(post, is(notNullValue()));
        assertThat(post.getName(), is("Refactoring Ruby applications"));
    }

    @Test
    public void findsAllPosts() throws Exception {
        List<Post> posts = postRepository.findAll();
        assertThat(posts, hasSize(2));
    }

    @Test
    public void accessesAllPostsByPage() throws Exception {
        Page<Post> page = postRepository.findAll(new PageRequest(0, 1));
        assertThat(page, is(notNullValue()));
        assertThat(page.isFirst(), is(true));
        assertThat(page.isLast(), is(false));
        assertThat(page.getNumberOfElements(), is(1));
    }

    @Test
    public void findsPostsByName() throws Exception {
        List<Post> posts = postRepository.findByName("Microservices Explained");
        assertThat(posts, hasItem(hasProperty("name", is("Microservices Explained"))));
    }
}
