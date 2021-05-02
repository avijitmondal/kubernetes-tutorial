package com.avijitmondal.tutorial.k8s.controller;

import com.avijitmondal.tutorial.k8s.model.User;
import com.avijitmondal.tutorial.k8s.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "id", required = false) String id) {
        List<User> users = new LinkedList<>();
        try {
            if (id != null && !id.isBlank()) {
                Optional<User> optionalUser = userRepository.findById(Long.valueOf(id));
                if (optionalUser.isPresent()) {
                    users.add(optionalUser.get());
                }
            } else if (name != null && !name.isBlank()) {
                users = userRepository.findByNameLike(name + "%");
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
