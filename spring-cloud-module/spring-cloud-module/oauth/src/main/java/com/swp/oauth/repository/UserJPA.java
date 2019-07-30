package com.swp.oauth.repository;

import com.swp.oauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJPA extends JpaRepository<User, String> {

    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE LOWER(u.username) = lower(:username) ")
    User findByUsernameCaseInsensitive(@Param("username") String username);

}
