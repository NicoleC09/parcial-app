package com.parcial.proxy.controller;

import com.parcial.proxy.service.RoundRobinProxyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProxyController {

    private final RoundRobinProxyService proxyService;

    public ProxyController(RoundRobinProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @GetMapping("/fibwin")
    public ResponseEntity<String> fibwin(@RequestParam("value") int value) {
        if (value < 2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "value must be >= 2");
        }

        return proxyService.forwardFibwin(value);
    }
}
