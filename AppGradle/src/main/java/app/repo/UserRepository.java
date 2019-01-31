package app.repo;

import app.dto.UserData;
import app.model.GroupModel;
import app.model.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Black on 12.02.2018.
 */
@org.springframework.stereotype.Repository
public class UserRepository implements Repository<UserModel, UserData> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(UserData userData) {
        UserModel userModel = new UserModel();
        userModel.setEmail(userData.getEmail());
        userModel.setGroupModel(entityManager.find(GroupModel.class, userData.getGroupId()));
        entityManager.persist(userModel);
        entityManager.flush();

    }

    @Override
    public UserModel get(long id) {
        return entityManager.find(UserModel.class, id);
    }

    @Override
    public List<UserModel> list() {
        return entityManager.createQuery("from UserModel ", UserModel.class)
                .getResultList();
    }

    @Override
    public void update(long id, UserData userData) {
        UserModel userModel = entityManager.find(UserModel.class, id);
        userModel.setEmail(userData.getEmail());
        userModel.getGroupModel().setGroupId(userData.getGroupId());
        entityManager.persist(userModel);
        entityManager.flush();
    }

    @Override
    public void delete(long id) {

        UserModel userModel = entityManager.find(UserModel.class, id);
        entityManager.remove(userModel);
        entityManager.flush();
        entityManager.clear();

    }

}