package com.avijitmondal.tutorial.k8s.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetailsTest {

    private Details details;

    @BeforeEach
    void setUp() {
        details = new Details("8080", "commander", "localhost");
    }

    @AfterEach
    void tearDown() {
        details = null;
    }

    @Test
    void getPort() {
        assertEquals(details.getPort(), "8080");
    }

    @Test
    void getHostname() {
        assertEquals(details.getHostname(), "commander");
    }

    @Test
    void getIp() {
        assertEquals(details.getIp(), "localhost");
    }
}