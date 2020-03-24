package com.cooligc.labs.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthEndpoint {

    @GetMapping("/heartbeat")
    public String sayAlive(){
        return "I am alive";
    }
}
