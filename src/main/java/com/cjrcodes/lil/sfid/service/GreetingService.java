package com.cjrcodes.lil.sfid.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cjrcodes.lil.sfid.aspect.Loggable;

@Service
public class GreetingService {
	
	@Value("${app.greeting}")
    private String greeting;

    public GreetingService(){
        super();
    }

    @Loggable
    public String getGreeting(String name){
        return greeting + " " + name;
    }
}
