package com.avijitmondal.tutorial.k8s.controller;

import com.avijitmondal.tutorial.k8s.model.Details;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.net.InetAddress;
import java.net.UnknownHostException;

@CrossOrigin
@RestController
public class DetailsController {

    private final Environment environment;

    public DetailsController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/details")
    public ResponseEntity<Details> getDetails() {

        try {
            var ip = InetAddress.getLocalHost();
            var hostname = ip.getHostName();
            var details = new Details(environment.getProperty("local.server.port"), ip.getHostName(), ip.getHostAddress());
            return new ResponseEntity<>(details, HttpStatus.OK);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        var details = new Details();
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }
}
