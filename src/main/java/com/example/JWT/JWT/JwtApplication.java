package com.example.JWT.JWT;

import com.example.JWT.JWT.Model.User;
import com.example.JWT.JWT.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class JwtApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Autowired
	UserRepository repo;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("mavin","mavin",true,"admin,student");
		User user2 = new User("mani","mani",true,"student");
		repo.save(user1);
		repo.save(user2);

	}


}
