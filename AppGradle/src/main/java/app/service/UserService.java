package app.service;

import org.springframework.transaction.annotation.Transactional;
import app.dto.UserData;
import app.model.UserModel;
import app.populator.Populator;
import app.repo.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 11.02.2018.
 */
@org.springframework.stereotype.Service
@Transactional(readOnly = false)
public class UserService implements Service<UserData, UserData> {

    @Resource(name = "userRepository")
    private Repository userRepository;

    @Resource(name = "userPopulator")
    private Populator userPopulator;

    public void save(UserData userData) {
        userRepository.save(userData);
    }

    @Override
    public UserData get(long id) {
        UserData userData = new UserData();
        UserModel userModel = (UserModel) userRepository.get(id);
        if (userModel != null) {
            userPopulator.populate(userModel, userData);
        }
        return userData;
    }

    @Override
    public List<UserData> list() {
        List<UserData> userDataList = new ArrayList<>();
        List list = userRepository.list();
        if (list.size() != 0) {
            userPopulator.populateList(list, userDataList);
        }
        return userDataList;
    }

    @Override
    public void update(long id, UserData userData) {
        userRepository.update(id, userData);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }
}
