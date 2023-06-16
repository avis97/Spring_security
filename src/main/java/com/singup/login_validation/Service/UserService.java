package com.singup.login_validation.Service;

import com.singup.login_validation.Dtos.RequestModelsUser;
import com.singup.login_validation.Entitys.User;

public interface UserService{

    User userRegister(RequestModelsUser user);

    void saveVerificationTokenForUser(String token, User user);
}
