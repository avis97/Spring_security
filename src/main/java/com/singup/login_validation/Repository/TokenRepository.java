package com.singup.login_validation.Repository;

import com.singup.login_validation.Entitys.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TokenRepository extends JpaRepository<VerificationToken,Integer>{

}
