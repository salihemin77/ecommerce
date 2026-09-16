package com.example.ecommerce.repository;

import com.example.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

public interface UserRepository  extends JpaRepository<User,Integer> {


}
