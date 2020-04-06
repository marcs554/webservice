package com.bellaria.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebserviceApplication {

	public static void main(String[] args) {
		try {
                    SpringApplication.run(WebserviceApplication.class, args);
                } catch (Exception e) {
                    e.printStackTrace();
                }
	}

}
