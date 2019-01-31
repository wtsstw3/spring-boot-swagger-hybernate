/**
 * Created by Black on 14.02.2018.
 */

import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import app.model.UserModel;

public class RelationTest {


    @Test
    public void getAllData() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/app/user/";
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<UserModel[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, UserModel[].class);
        UserModel[] userModels = responseEntity.getBody();
        for(UserModel userModel : userModels) {
            System.out.println("Id:"+userModel.getUserId()+", GroupId:"+", Email: "+userModel.getEmail());
        }
        Assert.noNullElements(userModels);
    }

}
