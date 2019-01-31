package app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Black on 12.02.2018.
 */
@Entity
@Table(name = "users")
public class UserModel extends AbstractModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @Column(name = "USER_ID", nullable = false, updatable = false)
    private Long userId;

    @Getter
    @Setter
    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Getter
    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "GROUP_ID")
    private GroupModel groupModel;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_TAG",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    private Collection<TagModel> tagCollection;


}
