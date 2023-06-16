package com.singup.login_validation.Service;

import com.singup.login_validation.Dtos.RequestModelsUser;
import com.singup.login_validation.Entitys.User;
import com.singup.login_validation.Entitys.VerificationToken;
import com.singup.login_validation.Repository.TokenRepository;
import com.singup.login_validation.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
       @Autowired
       UserRepository userRepository;
       @Autowired
       TokenRepository tokenRepository;
       @Autowired
       PasswordEncoder passwordEncoder;
        public User userRegister(RequestModelsUser user){
            User user1=new User();

            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setUserEmail(user.getUserEmail());
            user1.setRoll("USER");
            user1.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(user1);
            return user1;
        }
    public void saveVerificationTokenForUser(String token, User user){
        VerificationToken verificationToken=new
                VerificationToken(user,token);
        //save the token in the database
        tokenRepository.save(verificationToken);
    }
}
