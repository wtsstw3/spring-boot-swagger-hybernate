package app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Collection;


/**
 * Created by Black on 11.02.2018.
 */
@Entity
@Table(name = "groups")
public class GroupModel extends AbstractModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GROUP_ID", unique = true, nullable = false)
    @Getter
    @Setter
    public Integer groupId;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupModel")
    private Collection<UserModel> userCollection;

}
