package com.singup.login_validation.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestModelsUser{
    private String firstName;
    private String lastName;
    private String userEmail;
    private String password;
    private String matchingPassword;
}
