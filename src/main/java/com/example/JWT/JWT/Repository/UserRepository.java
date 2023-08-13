package com.example.JWT.JWT.Repository;

import com.example.JWT.JWT.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUserName(String name);
}
