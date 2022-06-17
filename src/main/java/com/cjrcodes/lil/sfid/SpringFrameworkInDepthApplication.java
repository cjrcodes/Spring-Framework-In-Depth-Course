package com.cjrcodes.lil.sfid;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cjrcodes.lil.sfid.config.ApplicationConfig;
import com.cjrcodes.lil.sfid.service.GreetingService;
import com.cjrcodes.lil.sfid.service.OutputService;
import com.cjrcodes.lil.sfid.service.TimeService;

//@SpringBootApplication
public class SpringFrameworkInDepthApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		try {
			
			OutputService outputService = context.getBean(OutputService.class);
			int i = 0;
			
			do {
				outputService.generateOutput();
				Thread.sleep(1000);
				i++;
			}
			while(i < 5);
		}
		finally {
	        ((AnnotationConfigApplicationContext)context).close();
	    }
		
		//SpringApplication.run(SpringFrameworkInDepthApplication.class, args);
	}

}
