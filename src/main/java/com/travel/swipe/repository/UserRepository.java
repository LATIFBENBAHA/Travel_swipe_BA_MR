package com.travel.swipe.repository;

import com.travel.swipe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long UserId);

    boolean existsByEmail(String email);

    User findByEmailAndMotdepass(String email, String motdepass);
}
