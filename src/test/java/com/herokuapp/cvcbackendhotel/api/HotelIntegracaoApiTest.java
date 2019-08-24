package com.herokuapp.cvcbackendhotel.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.cvcbackendhotel.bean.Hotel;
import com.herokuapp.cvcbackendhotel.bean.Room;
import com.herokuapp.cvcbackendhotel.integration.IntegrationTest;

/**
 * @author Marcos Pinho
 */
@RunWith(SpringRunner.class)
public class HotelIntegracaoApiTest extends IntegrationTest {
	
	private static Logger log = Logger.getLogger(HotelIntegracaoApiTest.class.getName());

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveBuscarTodosOsHoteisComOCodigoDaCidadeFornecidaECalcularSeuValorTotalDeComissao() throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(get("/hotels/city/1032/checkin/24-08-2019/checkout/29-08-2019/adultos/2/criancas/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        Hotel hotel = objectMapper.readValue(response.getContentAsString(), Hotel.class);
        
        log.info("");
        log.info("-------------------------------------------------------------------------------------------------------------------");
        
        log.info("Inicio deveBuscarTodosOsHoteisComOCodigoDaCidadeFornecidaECalcularSeuValorTotalDeComissao");
        
        log.info("Id : " + hotel.getId());
        log.info("Name : " + hotel.getName());
        log.info("CityCode : " + hotel.getCityCode());
        log.info("CityName : " + hotel.getCityName());
        
        for (Room room : hotel.getRooms()) {
        	log.info("Room ID : " + room.getRoomID());
        	log.info("Room CategoryName : " + room.getCategoryName());
        	log.info("Room TotalPrice : " + room.getTotalPrice());
		}
        
        log.info("Final deveBuscarTodosOsHoteisComOCodigoDaCidadeFornecidaECalcularSeuValorTotalDeComissao");
        
        Assert.assertEquals(BigDecimal.valueOf(65372175.61), hotel.getRooms().get(0).getTotalPrice());
    }

    @Test
    public void deveBuscarOHotelComSeuRespectivoCodigoFornecidoECalcularSeuValorDeComissao() throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(get("/hotels/1/checkin/24-08-2019/checkout/29-08-2019/adultos/2/criancas/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        Hotel hotel = objectMapper.readValue(response.getContentAsString(), Hotel.class);
        
        log.info("");
        log.info("-------------------------------------------------------------------------------------------------------------------");
        log.info("Inicio deveBuscarOHotelComSeuRespectivoCodigoFornecidoECalcularSeuValorDeComissao");
        
        log.info("Id : " + hotel.getId());
        log.info("Name : " + hotel.getName());
        log.info("CityCode : " + hotel.getCityCode());
        log.info("CityName : " + hotel.getCityName());
        
        for (Room room : hotel.getRooms()) {
        	log.info("Room ID : " + room.getRoomID());
        	log.info("Room CategoryName : " + room.getCategoryName());        	
        	log.info("Room TotalPrice : " + room.getTotalPrice());
		}
        
        log.info("Final deveBuscarOHotelComSeuRespectivoCodigoFornecidoECalcularSeuValorDeComissao");

        Assert.assertEquals(BigDecimal.valueOf(25669.21), hotel.getRooms().get(0).getTotalPrice());
    }

}
