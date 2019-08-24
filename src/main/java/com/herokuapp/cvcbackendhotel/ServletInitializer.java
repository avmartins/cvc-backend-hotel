package com.herokuapp.cvcbackendhotel;

/**
 * @author Anderson Virginio Martins
 * 
 *  Classe servlet auxiliar na inicialização do Spring Boot
 */

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CvcBackendHotelApplication.class);
	}

}
