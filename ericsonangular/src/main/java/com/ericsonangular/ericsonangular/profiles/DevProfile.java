package com.ericsonangular.ericsonangular.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ericsonangular.ericsonangular.services.DBService;

@Configuration
@Profile("dev")
public class DevProfile {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaDB() {
		
		this.dbService.instanciaDB();
	}

}
