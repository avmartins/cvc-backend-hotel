package com.herokuapp.cvcbackendhotel.api;

import java.util.logging.Logger;

/**
 * @author Anderson Virginio Martins
 * 
 *  Classe responsável por fazer a integração com a API hoteis
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.cvcbackendhotel.bean.Hotel;
import com.herokuapp.cvcbackendhotel.component.IntegrationComponent;
import com.herokuapp.cvcbackendhotel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelIntegracaoApi {
	
	private static Logger log = Logger.getLogger(HotelIntegracaoApi.class.getName());

	@Autowired
	private IntegrationComponent integration;

	@Autowired
	private HotelService service;
	
	@GetMapping(value = "/city/{cityCode}/checkin/{dateCheckin}/checkout/{dateCheckout}/adultos/{totAdults}/criancas/{totChildren}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Hotel> findHotelsByCodeCity(@PathVariable(value = "cityCode") Long cityCode,
			@PathVariable(value = "dateCheckin") String dateCheckin,
			@PathVariable(value = "dateCheckout") String dateCheckout,
			@PathVariable(value = "totAdults") Long totAdults,
			@PathVariable(value = "totChildren") Long totChildren) {
		
		log.info("");
        log.info("-------------------------------------------------------------------------------------------------------------------");
		log.info("Inicio findHotelsByCodeCity");
		
		log.info("Busca HotelsByCodeCity : " + cityCode);
		
		Hotel[] hotels = this.integration.callHotelsByCodeCity(cityCode);
		
		log.info("dateCheckin : " + dateCheckin);
		log.info("dateCheckout : " + dateCheckout);
		log.info("totAdults : " + totAdults);
		log.info("totChildren : " + totChildren);
		
		Hotel hotel = this.service.run(hotels, dateCheckin, dateCheckout, totAdults, totChildren);
		hotel.removePriceBody();
		
		log.info("Final findHotelsByCodeCity");
		
		return ResponseEntity.ok(hotel);
	}

	@GetMapping(value = "/{id}/checkin/{dateCheckin}/checkout/{dateCheckout}/adultos/{totAdults}/criancas/{totChildren}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Hotel> findHotelsByCode(@PathVariable(value = "id") Long id,
			@PathVariable(value = "dateCheckin") String dateCheckin,
			@PathVariable(value = "dateCheckout") String dateCheckout,
			@PathVariable(value = "totAdults") Long totAdults,
			@PathVariable(value = "totChildren") Long totChildren) {
		
		log.info("");
        log.info("-------------------------------------------------------------------------------------------------------------------");
		
		log.info("Inicio findHotelsByCode");
		
		log.info("Busca callHotelsByCode : " + id);
		
		Hotel[] hotels = this.integration.callHotelsByCode(id);		
		
		log.info("dateCheckin : " + dateCheckin);
		log.info("dateCheckout : " + dateCheckout);
		log.info("totAdults : " + totAdults);
		log.info("totChildren : " + totChildren);
		
		Hotel hotel = this.service.run(hotels, dateCheckin, dateCheckout, totAdults, totChildren);
		hotel.removePriceBody();
		
		log.info("Final findHotelsByCode");
			
		return ResponseEntity.ok(hotel);
	}

}
