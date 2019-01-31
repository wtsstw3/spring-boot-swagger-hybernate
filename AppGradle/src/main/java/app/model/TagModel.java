package app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Black on 11.02.2018.
 */
@Entity
@Table(name = "tags")
public class TagModel extends AbstractModel {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TAG_ID", unique = true, nullable = false)
    private long tagId;

    @Getter
    @Setter
    @Column(name = "Name", unique = true, nullable = false, length = 50)
    private String name;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "tagCollection", cascade = CascadeType.ALL)
    private Collection<UserModel> userCollection;
}
