package app.populator;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import app.dto.UserData;
import app.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 12.02.2018.
 */
@Component
public class UserPopulator implements Populator<UserModel, UserData> {
    public void populate(final UserModel source, final UserData target) {
        Assert.notNull(source, "Parameter source cannot be null.");
        Assert.notNull(target, "Parameter target cannot be null.");

        target.setUserId(source.getUserId());
        target.setEmail(source.getEmail());
        target.setGroupId(source.getGroupModel().getGroupId());
        List<UserData.UserTagData> userTagDatas = new ArrayList<>();
        source.getTagCollection().forEach(item-> {
            UserData.UserTagData userTagData = new UserData.UserTagData();
            userTagData.setTagId(item.getTagId());
            userTagData.setName(item.getName());
            userTagDatas.add(userTagData);
        });
        target.setTagCollection(userTagDatas);
    }

    @Override
    public void populateList(List<UserModel> modelList, List<UserData> dataList) {
        modelList.forEach(item -> {
            UserData userData = new UserData();
            populate(item, userData);
            dataList.add(userData);
        });
    }
}
