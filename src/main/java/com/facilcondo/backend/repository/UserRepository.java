package com.facilcondo.backend.repository;

import com.facilcondo.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Query personalizzate future
    User findByEmail(String email);
}
