package rubengil;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public String getName() {
        return name;
    }
}
