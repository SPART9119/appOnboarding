package com.vonage.appOnboarding.Services;

import com.vonage.appOnboarding.Utils.EndpointApiCaller;
import com.vonage.appOnboarding.Utils.SaviyntConfiguration;
import com.vonage.appOnboarding.Models.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaviyntRestCallImpl implements SaviyntRestCall {



    @Autowired
    private SaviyntConfiguration saviyntConfiguration;
    @Autowired
    private EndpointApiCaller endpointApiCaller;

    @Override
    public List<Object> getEndpoints() throws Exception {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "application/json");
        List<Endpoint> endpoints = saviyntConfiguration.getEndpoints();


        return endpointApiCaller.callEndpoints(endpoints);


    }
}
