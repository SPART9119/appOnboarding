package com.vonage.appOnboarding.Utils;

import com.vonage.appOnboarding.Models.Endpoint;
import com.vonage.appOnboarding.Services.RestMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;

@Component
public class EndpointApiCaller {
    @Autowired
    private SaviyntConfiguration saviyntConfiguration;
    @Autowired
    private RestMethods restMethods;

    public List<Object> callEndpoints(List<Endpoint> endpoints) {
        List<Object> responses = new ArrayList<>();
        Exception errorException = null;
        String errorEndpointName = null;

        for (Endpoint endpoint : endpoints) {
            String fullUrl = saviyntConfiguration.getBaseurl() + endpoint.getUrl();
            try {
                ResponseEntity<Object> response = restMethods.getCall(fullUrl, endpoint.getType());
                responses.add(response.getBody());
            } catch (HttpClientErrorException | HttpServerErrorException ex) {
                errorException = ex;
                errorEndpointName = endpoint.getName();
                break;
            } catch (Exception ex) {
                errorException = ex;
                errorEndpointName = endpoint.getName();
                break;
            }
        }

        if (errorException != null) {
            String errorMessage = "Error calling endpoint: " + errorEndpointName +
                    (errorException instanceof HttpClientErrorException || errorException instanceof HttpServerErrorException ?
                            " - Status Code: " + ((HttpClientErrorException) errorException).getStatusCode() : "");
            responses.add(errorMessage);
        }

        return responses;
    }
}
