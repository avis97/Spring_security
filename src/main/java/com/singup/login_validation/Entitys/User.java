package com.singup.login_validation.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_table")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstName;
    private String lastName;
    private String userEmail;
    @Column(length = 60)
    private String password;
    private String roll;
    private boolean enabled=false;

}
