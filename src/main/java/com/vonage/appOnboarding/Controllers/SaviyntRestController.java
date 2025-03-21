package com.vonage.appOnboarding.Controllers;

import com.vonage.appOnboarding.Services.SaviyntRestCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SaviyntRestController {
    
    @Autowired
    private SaviyntRestCall saviyntRestCall;

    @GetMapping("/endpoints")
    public List<Object> getEndpoints() throws Exception {
        return saviyntRestCall.getEndpoints();
    }
    // hello
}


