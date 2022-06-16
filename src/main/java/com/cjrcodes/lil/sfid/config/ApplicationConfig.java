package com.cjrcodes.lil.sfid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.cjrcodes.lil.sfid.service.GreetingService;
import com.cjrcodes.lil.sfid.service.OutputService;
import com.cjrcodes.lil.sfid.service.TimeService;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

	@Value("${app.greeting}")
	private String greeting;

	@Value("${app.name}")
	private String name;

	@Autowired
	private GreetingService greetingService;

	@Autowired
	private TimeService timeService;

	
	

	@Bean
	@Profile("!dev")
	public TimeService timeService() {
		return new TimeService(true);
	}
	
	@Bean
	@Profile("dev")
	public TimeService timeService12() {
		return new TimeService(false);
	}

	@Bean
	public OutputService outputService() {
		return new OutputService(greetingService, timeService, name);
	}

	@Bean
	public GreetingService greetingService() {
		return new GreetingService(greeting);
	}
}