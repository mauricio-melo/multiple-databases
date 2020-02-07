package com.mmelo.twodatabases.users.repository;

import com.mmelo.twodatabases.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}