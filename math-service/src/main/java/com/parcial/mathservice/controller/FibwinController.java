package com.parcial.mathservice.controller;

import com.parcial.mathservice.service.FibwinService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class FibwinController {

    private final FibwinService fibwinService;

    public FibwinController(FibwinService fibwinService) {
        this.fibwinService = fibwinService;
    }

    @GetMapping("/fibwin")
    public Map<String, Object> fibwin(@RequestParam("value") int value) {
        if (value < 2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "value must be >= 2");
        }

        return Map.of(
                "operation", "Fibonacci con ventana K=3",
                "input", value,
                "output", fibwinService.buildOutput(value)
        );
    }
}
