package com.vonage.appOnboarding.Utils;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.vonage.appOnboarding.Models.Endpoint;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("saviynt.application")

public class SaviyntConfiguration {
    private String baseurl;
	private List<Endpoint> endpoints;

	public String getBaseurl() {
		return baseurl;
	}
	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	public List<Endpoint> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}
}
