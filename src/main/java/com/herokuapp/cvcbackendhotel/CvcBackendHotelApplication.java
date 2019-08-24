package com.herokuapp.cvcbackendhotel;

/**
 * @author Anderson Virginio Martins
 * 
 *  Classe inicialização do Spring Boot
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.herokuapp.cvcbackendhotel.config.ConfigProperty;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperty.class)
public class CvcBackendHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvcBackendHotelApplication.class, args);
	}

}
