package com.parcial.proxy.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RoundRobinProxyService {

    private final List<String> targets;
    private final AtomicInteger nextIndex = new AtomicInteger(0);
    private final RestClient restClient = RestClient.create();

    public RoundRobinProxyService() {
        String url1 = System.getenv("MATH_SERVICE_URL_1");
        String url2 = System.getenv("MATH_SERVICE_URL_2");

        if (url1 == null || url1.isBlank() || url2 == null || url2.isBlank()) {
            throw new IllegalStateException("MATH_SERVICE_URL_1 and MATH_SERVICE_URL_2 must be configured");
        }

        this.targets = List.of(url1, url2);
    }

    public ResponseEntity<String> forwardFibwin(int value) {
        String target = pickTarget();
        String url = target + "/fibwin?value=" + value;

        try {
            String body = restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(String.class);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            return new ResponseEntity<>(body, headers, HttpStatus.OK);
        } catch (RestClientResponseException ex) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            return new ResponseEntity<>(ex.getResponseBodyAsString(), headers, HttpStatus.valueOf(ex.getStatusCode().value()));
        }
    }

    private String pickTarget() {
        int index = Math.floorMod(nextIndex.getAndIncrement(), targets.size());
        return targets.get(index);
    }
}
