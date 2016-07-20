package rubengil.model;

import javax.persistence.Entity;

@Entity
public class Post extends AbstractEntity {

    private String name;

    public String getName() {
        return name;
    }
}
