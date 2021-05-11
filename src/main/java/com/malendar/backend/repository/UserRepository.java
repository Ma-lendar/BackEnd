package com.malendar.backend.repository;

import com.malendar.backend.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "authorities") // Lazy 조회가 아닌 Eager 조회로 authorities 정보를 조인해서 가져옴
    Optional<User> findOneWithAuthoritiesByEmail(String email);
    Optional<User> findOneWithAuthoritiesByUsername(String username);
    Optional<User> findByEmail(String email);
}