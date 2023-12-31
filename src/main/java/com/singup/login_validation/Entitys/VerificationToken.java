package com.singup.login_validation.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationToken{
    private static final int EXPIRATION_TIME=10;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String token;
    private Date expirationTime;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId",
               nullable = false,
               foreignKey = @ForeignKey(name="VERIFY_TOKEN")
               )
    private User user;

    public VerificationToken(User user,String token){
        super();
        this.user=user;
        this.token=token;
        this.expirationTime=calculateDate(EXPIRATION_TIME);
    }
    public VerificationToken(String token){
        super();
        this.token=token;
        this.expirationTime=calculateDate(EXPIRATION_TIME);
    }
    private Date calculateDate(int expirationTime){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,expirationTime);
        return new Date(calendar.getTime().getTime());
    }


}
