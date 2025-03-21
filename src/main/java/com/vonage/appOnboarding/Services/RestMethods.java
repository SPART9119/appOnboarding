package com.vonage.appOnboarding.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestMethods {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<Object> getCall(String url, String methodType) {
        HttpMethod httpMethod = HttpMethod.valueOf(methodType);
        return restTemplate.getForEntity(url, Object.class);

    }
}
