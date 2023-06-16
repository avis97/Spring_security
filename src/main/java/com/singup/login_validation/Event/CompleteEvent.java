package com.singup.login_validation.Event;

import com.singup.login_validation.Entitys.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class CompleteEvent extends ApplicationEvent{
    private User user;
    private String applicationUrl;
    public CompleteEvent(User user,String applicationUrl){
        super(user);
        this.user=user;
        this.applicationUrl=applicationUrl;
    }
}
