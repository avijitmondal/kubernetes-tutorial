package com.avijitmondal.tutorial.k8s.repository;

import com.avijitmondal.tutorial.k8s.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameLike(String name);
}
