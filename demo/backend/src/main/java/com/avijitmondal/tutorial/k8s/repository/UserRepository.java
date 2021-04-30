package com.avijitmondal.tutorial.k8s.repository;

import com.avijitmondal.tutorial.k8s.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByName(String name);
}
