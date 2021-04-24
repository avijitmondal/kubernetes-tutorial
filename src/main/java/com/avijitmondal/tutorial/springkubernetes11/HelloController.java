package com.avijitmondal.tutorial.springkubernetes11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@CrossOrigin
@RestController
public class HelloController {

    @Autowired
    private Environment environment;

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/details")
    public String getHostname() {

        try {
            var ip = InetAddress.getLocalHost();
            var hostname = ip.getHostName();
            return "Your current IP address: " + ip.getHostAddress() + " , Port: " + environment.getProperty("local.server.port") + " , Hostname: " + hostname;

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Unable to check hostname";
    }
}
