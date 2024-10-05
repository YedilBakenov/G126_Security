package com.example.testSecurity.repository;

import com.example.testSecurity.model.Permission;
import com.example.testSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);
}
