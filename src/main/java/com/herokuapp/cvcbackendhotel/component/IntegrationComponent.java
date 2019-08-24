package com.herokuapp.cvcbackendhotel.component;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.herokuapp.cvcbackendhotel.bean.Hotel;
import com.herokuapp.cvcbackendhotel.component.util.CallUtil;
import com.herokuapp.cvcbackendhotel.config.ConfigProperty;
import com.herokuapp.cvcbackendhotel.exception.RecurseNotFoundException;

/**
 * * @author Anderson Virginio Martins
 * 
 * Componente responsável por fazer a deserialização do objeto com as informações vindas do serviço consumido.
 */
@Component
public class IntegrationComponent {
	
	private static Logger log = Logger.getLogger(IntegrationComponent.class.getName());

    private RestTemplate restTemplate;

    @Autowired
    private ConfigProperty property;
    
    public IntegrationComponent() {
        this.restTemplate = new RestTemplate();
    }

    public Hotel[] callHotelsByCodeCity(Long cityCode) {
        return this.callHotels(cityCode, CallUtil.executeHotelsAvail(this.property.getUrl()));
    }

    public Hotel[] callHotelsByCode(Long id) {
        return this.callHotels(id, CallUtil.executeHotels(this.property.getUrl()));
    }

    public Hotel[] callHotels(Long code, String uri) {
        Hotel[] hotels = this.restTemplate.getForObject(uri, Hotel[].class, code);
        if(hotels == null || ( hotels != null && hotels.length == 0)) { 
        	
        	RecurseNotFoundException rnf = new RecurseNotFoundException(property.getNoHotelsFound(), property.getApiNotReturn());
        	log.log(Level.SEVERE, property.getNoHotelsFound(), rnf);
            throw rnf;
        }
        return hotels;
    }

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ConfigProperty getProperty() {
		return property;
	}

	public void setProperty(ConfigProperty property) {
		this.property = property;
	}

}
