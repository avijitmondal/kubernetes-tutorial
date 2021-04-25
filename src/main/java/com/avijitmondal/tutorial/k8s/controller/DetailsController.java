package com.avijitmondal.tutorial.k8s.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@CrossOrigin
@RestController
public class DetailsController {

    @Autowired
    private Environment environment;

    @GetMapping("/details")
    public String getHostname() {

        try {
            var ip = InetAddress.getLocalHost();
            var hostname = ip.getHostName();
            return "Your current IP address: " + ip.getHostAddress() + ", Port: " + environment.getProperty("local.server.port") + " , Hostname: " + hostname;

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Unable to check hostname";
    }
}
