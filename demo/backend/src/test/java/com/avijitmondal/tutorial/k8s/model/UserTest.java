package com.avijitmondal.tutorial.k8s.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(10001, "Avijit", "p10001");
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

    @Test
    void getId() {
        assertEquals(user.getId(), 10001);
    }

    @Test
    void getName() {
        assertEquals(user.getName(), "Avijit");
    }

    @Test
    void getPassportNumber() {
        assertEquals(user.getPassportNumber(), "p10001");
    }
}