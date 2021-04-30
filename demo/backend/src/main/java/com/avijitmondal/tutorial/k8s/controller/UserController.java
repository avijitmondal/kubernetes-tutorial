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

import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public ResponseEntity<User> sayHello(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "id", required = false) String id) {
        try {
            Optional<User> optionalUser = Optional.empty();
            if (name != null && !name.isBlank()) {
                optionalUser = userRepository.findByName(name);
            } else if (id != null && !id.isBlank()) {
                optionalUser = userRepository.findById(Long.valueOf(id));
            }
            if (optionalUser.isPresent())
                return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        var user = new User(0, "Hello World!", null);
        return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    }
}
