package com.singup.login_validation.Controller;

import com.singup.login_validation.Dtos.RequestModelsUser;
import com.singup.login_validation.Entitys.User;
import com.singup.login_validation.Event.CompleteEvent;
import com.singup.login_validation.Service.UserService;
import com.singup.login_validation.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    UserService userService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String userRegister(@RequestBody RequestModelsUser user, final HttpServletRequest request){
        User user1=userService.userRegister(user);
        publisher.publishEvent(new CompleteEvent(
                user1,
                applicationUrl(request)
        ));
        return "Register is successfully done";
    }

    private String applicationUrl(HttpServletRequest request){
        return "http://"+
                request.getServerName()+
                ":"+
                request.getServerPort()+
                request.getContextPath();
    }
}
