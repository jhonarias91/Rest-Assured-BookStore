package com.bookstore;

import com.bookstore.model.Error;
import com.bookstore.model.User;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class UserLoginTest extends ApiUtil {

    @Test
    public void testLoginUser() {

        final Response newUserResponse = createUser(getARandomUserName(), "123456abC*");
        if (newUserResponse.getStatusCode() != 201) {
            Error error = newUserResponse.as(Error.class);
            System.out.println(error.getMessage());
            return;
        }
        //Assume the userCreation is ok, the password rules hasn't change and doesn't exists a user with the same username
        final User user = newUserResponse.as(User.class);
        System.out.println(user.getUserID());
    }


    private String getARandomUserName(){
        return "usr" + System.currentTimeMillis();
    }

}
