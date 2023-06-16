package com.singup.login_validation.Repository;

import com.singup.login_validation.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
