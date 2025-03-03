package com.example.graduation_work_BE;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HealthController {

    @GetMapping("/")
    public String health(){
        return "8080 port server on";
    }
}
