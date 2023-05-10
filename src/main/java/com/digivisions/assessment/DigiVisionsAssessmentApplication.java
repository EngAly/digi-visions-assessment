package com.digivisions.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@SpringBootApplication
@RestController
public class DigiVisionsAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigiVisionsAssessmentApplication.class, args);
    }

    @GetMapping("health")
    public ZonedDateTime checkHealth() {
        return ZonedDateTime.now();
    }
}
