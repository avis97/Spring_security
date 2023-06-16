package com.singup.login_validation.Event.Listener;

import com.singup.login_validation.Entitys.User;
import com.singup.login_validation.Event.CompleteEvent;
import com.singup.login_validation.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.events.CommentEvent;

import java.util.UUID;

@Slf4j
@Component
public class CompleteEventListener implements ApplicationListener<CompleteEvent>{
    @Autowired
    UserService userService;
    @Override
    public void onApplicationEvent(CompleteEvent event){
        User user=event.getUser();
        String token= UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);

        String url=event.getApplicationUrl()
                +"verifyRegistration?token="
                +token;

        log.info("Click the link for verify your account:{}",url);

    }
}
