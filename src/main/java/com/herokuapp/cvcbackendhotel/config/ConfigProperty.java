package com.herokuapp.cvcbackendhotel.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("config")
public class ConfigProperty {

    private String url;
    private String noHotelsFound;    
    private String apiNotReturn;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNoHotelsFound() {
		return noHotelsFound;
	}

	public void setNoHotelsFound(String noHotelsFound) {
		this.noHotelsFound = noHotelsFound;
	}

	public String getApiNotReturn() {
		return apiNotReturn;
	}

	public void setApiNotReturn(String apiNotReturn) {
		this.apiNotReturn = apiNotReturn;
	}

    
}
