package app.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import app.dto.UserData;
import app.service.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Black on 11.02.2018.
 */
@RestController
@Path("/user")
@Api
public class UserController {

    @Resource(name = "userService")
    private Service userService;

    @GET
    @ApiOperation(value = "Get user")
    @Path("/{userId}")
    @Produces("application/json")
    public UserData getUser(@PathParam("userId") long userId) {
        UserData userData = (UserData) userService.get(userId);
        return userData;
        /*return ResponseEntity.ok().body(book);*/
    }

    @GET
    @ApiOperation(value = "Get List of Users")
    @Path("/")
    @Produces("application/json")
    public List<UserData> getUserList() {
        List<UserData> users = userService.list();
        return users;
    }

    @POST
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public ResponseEntity addUser(UserData user) {
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @PUT
    @Consumes("application/json")
    @Path("/{userId}")
    public ResponseEntity updateUser(@PathParam("userId") long userId, UserData user) {
        UserData userData = (UserData) userService.get(userId);
        userService.update(userId, user);
        return ResponseEntity.ok().build();
    }
    @DELETE
    @Path("/{userId}")
    public ResponseEntity deleteUser(@PathParam("userId") long userId) {
        UserData userData = (UserData) userService.get(userId);
        if(userData == null) {
            return ResponseEntity.notFound().build();
        }
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }
}
