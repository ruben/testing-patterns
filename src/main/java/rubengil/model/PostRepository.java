package rubengil.model;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    List<Post> findAll();

    List<Post> findByName(String name);
}
